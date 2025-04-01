import * as std from '@jkcfg/std';
import * as param from '@jkcfg/std/param';
import * as k8s from '@jkcfg/kubernetes/api';

const appName = 'collection';
const image = "monroeshindelar/collection";
const namespace = "collection";

const dbHost = param.String('dbHost', 'jdbc:postgresql://' + appName + '-svc.' + namespace + '.svc.cluster.local/collection');
const dbPort = param.Number('dbPort', 5432);
const psqlReplicas = param.Number('psqlReplicas', 1);
const servicePort = param.Number('servicePort', 8080);
const replicas = param.Number('replicas', 0);
const version = param.String ('version', '');
const url = param.String('url', '');

const ingressLabels = {
    app: appName,
    'app.kubernetes.io/instance': 'traefik-networking',
    'app.kubernetes.io/name': 'traefik'
};

const labels = {
    app: appName
};

const labelsPsql = {
    app: appName + '-psql'
};

const ingress = {
    metadata: {
        labels: ingressLabels,
        namespace: namespace,
        name: appName + '-ingress',
    },
    kind: 'IngressRoute',
    apiVersion: 'traefik.io/v1alpha1',
    spec: {
        entryPoints: ["websecure"],
        routes: [{
            kind: 'Rule',
            match: 'Host(`' + url + '`)',
            priority: 10,
            services: [{
                name: appName + '-svc',
                port: servicePort
            }]
        }],
        tls: {
            certResolver: 'porkbun'
        }
    }
};

const service = new k8s.core.v1.Service(appName + '-svc', {
    metadata: {
        labels: labels,
        namespace: namespace,
    },
    spec: {
        ports: [
            {
                name: 'service',
                port: servicePort,
                protocol: 'TCP',
                targetPort: servicePort
            }
        ],
        type: 'ClusterIP'
    },
    selector: {
        app: appName
    }
});

const servicePsql = new k8s.core.v1.Service(appName + '-svc-psql', {
    metadata: {
        labels: labelsPsql,
        namespace: namespace,
    },
    spec: {
        ports: [
            {
                name: 'db',
                port: dbPort,
                protocol: 'TCP',
                targetPort: dbPort
            }
        ],
        type: 'ClusterIP'
    },
    selector: {
        app: appName + '-psql'
    }
});

const deployment = new k8s.apps.v1.Deployment(appName, {
    metadata: {
        labels: labels,
        namespace: namespace,
    },
    spec: {
        replicas: replicas,
        selector: {
            matchLabels: labels
        },
        template: {
            metadata: {
                labels: labels
            },
            spec: {
                containers: [
                    {
                        envFrom: [
                            {
                                configMapRef: {
                                    name: appName + '-cm'
                                }
                            }
                        ],
                        image: image + ':' + version,
                        name: appName,
                        imagePullPolicy: 'IfNotPresent',
                        ports: [{
                            containerPort: servicePort,
                            protocol: 'TCP'
                        }],
                    }
                ]
            }
        }  
    }
});

const psql = new k8s.apps.v1.Deployment(appName + '-psql', {
    metadata: {
        labels: labelsPsql,
        namespace: namespace,
    },
    spec: {
        replicas: psqlReplicas,
        selector: {
            matchLabels: labelsPsql
        },
        template: {
            metadata: {
                labels: labelsPsql
            },
            spec: {
                containers: [
                    {
                        name: appName + '-psql',
                        image: 'postgres:latest',
                        imagePullPolicy: 'IfNotPresent',
                        ports: [
                            {
                                containerPort: dbPort,
                                protocol: 'TCP'
                            }
                        ],
                        envFrom: [
                            {
                                configMapRef: {
                                    name: appName + '-psql-cm'
                                }
                            },
                            {
                                secretRef: {
                                    name: appName + '-psql-secret'
                                }
                            }
                        ],
                        volumeMounts: [
                            {
                                mountPath: '/var/lib/postgresql/data',
                                name: appName + '-psql-data'
                            }
                        ]
                    }
                ],
                volumes: [
                    {
                        name: appName + '-psql-data',
                        persistentVolumeClaim: {
                            claimName: appName + '-psql'
                        }
                    }
                ]
            }
        }
    }
});

const pvc = new k8s.core.v1.PersistentVolumeClaim(appName + '-psql', {
    metadata: {
        labels: labelsPsql,
        namespace: namespace,
    },
    spec: {
        accessModes: ["ReadWriteOnce"],
        resources: {
            requests: {
                storage: '50Gi'
            }
        }
    }
});

const cmService = new k8s.core.v1.ConfigMap(appName + '-cm', {
    metadata: {
        labels: labels,
        namespace: namespace
    },
    data: {
        POSTGRES_HOST: dbHost
    }
});

const cmDb = new k8s.core.v1.ConfigMap(appName + '-psql-cm', {
    metadata: {
        labels: labels,
        namespace: namespace
    },
    data: {
        POSTGRES_USER: 'postgres'
    }
});

const collection = [
    deployment,
    psql,
    service,
    servicePsql,
    ingress,
    pvc,
    cmService,
    cmDb
];

std.write(collection,`manifests/collection/collection.yaml`, {format: std.Format.YAMLStream});