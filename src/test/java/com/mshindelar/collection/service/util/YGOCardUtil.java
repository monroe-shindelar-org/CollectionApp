package com.mshindelar.collection.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mshindelar.collection.YGOPROApi.dto.YGOCardDto;

import java.util.List;

public class YGOCardUtil {
    private static final String PAYLOAD = "{\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"id\": 19596712,\n" +
            "            \"name\": \"Abyss-scale of Cetus\",\n" +
            "            \"type\": \"Spell Card\",\n" +
            "            \"humanReadableCardType\": \"Equip Spell\",\n" +
            "            \"frameType\": \"spell\",\n" +
            "            \"race\": \"Equip\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/abyss-scale-of-cetus-1687\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Cosmo Blazer\",\n" +
            "                    \"set_code\": \"CBLZ-EN061\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 19596712,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/19596712.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/19596712.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/19596712.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.14\",\n" +
            "                    \"tcgplayer_price\": \"0.23\",\n" +
            "                    \"ebay_price\": \"0.99\",\n" +
            "                    \"amazon_price\": \"0.20\",\n" +
            "                    \"coolstuffinc_price\": \"0.49\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 8719957,\n" +
            "            \"name\": \"Abyss-scale of the Kraken\",\n" +
            "            \"type\": \"Spell Card\",\n" +
            "            \"humanReadableCardType\": \"Equip Spell\",\n" +
            "            \"frameType\": \"spell\",\n" +
            "            \"race\": \"Equip\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/abyss-scale-of-the-kraken-740\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN056\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 8719957,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/8719957.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/8719957.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/8719957.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.24\",\n" +
            "                    \"tcgplayer_price\": \"0.30\",\n" +
            "                    \"ebay_price\": \"0.99\",\n" +
            "                    \"amazon_price\": \"0.20\",\n" +
            "                    \"coolstuffinc_price\": \"0.25\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 72932673,\n" +
            "            \"name\": \"Abyss-scale of the Mizuchi\",\n" +
            "            \"type\": \"Spell Card\",\n" +
            "            \"humanReadableCardType\": \"Equip Spell\",\n" +
            "            \"frameType\": \"spell\",\n" +
            "            \"race\": \"Equip\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/abyss-scale-of-the-mizuchi-6124\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"2014 Mega-Tin Mega Pack\",\n" +
            "                    \"set_code\": \"MP14-EN040\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Lord of the Tachyon Galaxy\",\n" +
            "                    \"set_code\": \"LTGY-EN064\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 72932673,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/72932673.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/72932673.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/72932673.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.23\",\n" +
            "                    \"tcgplayer_price\": \"0.15\",\n" +
            "                    \"ebay_price\": \"1.59\",\n" +
            "                    \"amazon_price\": \"0.96\",\n" +
            "                    \"coolstuffinc_price\": \"0.49\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 79206750,\n" +
            "            \"name\": \"Abyss-scorn\",\n" +
            "            \"type\": \"Trap Card\",\n" +
            "            \"humanReadableCardType\": \"Normal Trap\",\n" +
            "            \"frameType\": \"trap\",\n" +
            "            \"race\": \"Normal\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/abyss-scorn-6649\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Cosmo Blazer\",\n" +
            "                    \"set_code\": \"CBLZ-EN075\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 79206750,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/79206750.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/79206750.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/79206750.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.14\",\n" +
            "                    \"tcgplayer_price\": \"0.14\",\n" +
            "                    \"ebay_price\": \"0.99\",\n" +
            "                    \"amazon_price\": \"0.25\",\n" +
            "                    \"coolstuffinc_price\": \"0.25\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 60202749,\n" +
            "            \"name\": \"Abyss-sphere\",\n" +
            "            \"type\": \"Trap Card\",\n" +
            "            \"humanReadableCardType\": \"Continuous Trap\",\n" +
            "            \"frameType\": \"trap\",\n" +
            "            \"race\": \"Continuous\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/abyss-sphere-5107\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN072\",\n" +
            "                    \"set_rarity\": \"Ultimate Rare\",\n" +
            "                    \"set_rarity_code\": \"(UtR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN072\",\n" +
            "                    \"set_rarity\": \"Ultra Rare\",\n" +
            "                    \"set_rarity_code\": \"(UR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 60202749,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/60202749.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/60202749.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/60202749.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"4.73\",\n" +
            "                    \"tcgplayer_price\": \"5.87\",\n" +
            "                    \"ebay_price\": \"4.15\",\n" +
            "                    \"amazon_price\": \"17.99\",\n" +
            "                    \"coolstuffinc_price\": \"0.00\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 34707034,\n" +
            "            \"name\": \"Abyss-squall\",\n" +
            "            \"type\": \"Trap Card\",\n" +
            "            \"humanReadableCardType\": \"Normal Trap\",\n" +
            "            \"frameType\": \"trap\",\n" +
            "            \"race\": \"Normal\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/abyss-squall-2949\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN071\",\n" +
            "                    \"set_rarity\": \"Super Rare\",\n" +
            "                    \"set_rarity_code\": \"(SR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 34707034,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/34707034.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/34707034.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/34707034.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"1.10\",\n" +
            "                    \"tcgplayer_price\": \"0.48\",\n" +
            "                    \"ebay_price\": \"2.29\",\n" +
            "                    \"amazon_price\": \"1.38\",\n" +
            "                    \"coolstuffinc_price\": \"0.49\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 23545031,\n" +
            "            \"name\": \"Mermail Abyssalacia\",\n" +
            "            \"typeline\": [\n" +
            "                \"Sea Serpent\",\n" +
            "                \"Link\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Link Monster\",\n" +
            "            \"humanReadableCardType\": \"Link Effect Monster\",\n" +
            "            \"frameType\": \"link\",\n" +
            "            \"race\": \"Sea Serpent\",\n" +
            "            \"atk\": 1600,\n" +
            "            \"def\": null,\n" +
            "            \"level\": 0,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"linkval\": 2,\n" +
            "            \"linkmarkers\": [\n" +
            "                \"Bottom-Left\",\n" +
            "                \"Bottom-Right\"\n" +
            "            ],\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssalacia-9078\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"2020 Tin of Lost Memories Mega Pack\",\n" +
            "                    \"set_code\": \"MP20-EN095\",\n" +
            "                    \"set_rarity\": \"Super Rare\",\n" +
            "                    \"set_rarity_code\": \"(SR)\",\n" +
            "                    \"set_price\": \"1.44\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Dark Neostorm\",\n" +
            "                    \"set_code\": \"DANE-EN094\",\n" +
            "                    \"set_rarity\": \"Ultra Rare\",\n" +
            "                    \"set_rarity_code\": \"(UR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 23545031,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/23545031.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/23545031.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/23545031.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.27\",\n" +
            "                    \"tcgplayer_price\": \"0.23\",\n" +
            "                    \"ebay_price\": \"0.99\",\n" +
            "                    \"amazon_price\": \"0.99\",\n" +
            "                    \"coolstuffinc_price\": \"0.39\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 75180828,\n" +
            "            \"name\": \"Mermail Abyssbalaen\",\n" +
            "            \"typeline\": [\n" +
            "                \"Aqua\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Aqua\",\n" +
            "            \"atk\": 2500,\n" +
            "            \"def\": 2000,\n" +
            "            \"level\": 7,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssbalaen-6322\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"2014 Mega-Tin Mega Pack\",\n" +
            "                    \"set_code\": \"MP14-EN055\",\n" +
            "                    \"set_rarity\": \"Ultra Rare\",\n" +
            "                    \"set_rarity_code\": \"(UR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Lord of the Tachyon Galaxy\",\n" +
            "                    \"set_code\": \"LTGY-EN083\",\n" +
            "                    \"set_rarity\": \"Ultimate Rare\",\n" +
            "                    \"set_rarity_code\": \"(UtR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Lord of the Tachyon Galaxy\",\n" +
            "                    \"set_code\": \"LTGY-EN083\",\n" +
            "                    \"set_rarity\": \"Ultra Rare\",\n" +
            "                    \"set_rarity_code\": \"(UR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 75180828,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/75180828.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/75180828.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/75180828.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.35\",\n" +
            "                    \"tcgplayer_price\": \"0.22\",\n" +
            "                    \"ebay_price\": \"2.00\",\n" +
            "                    \"amazon_price\": \"0.49\",\n" +
            "                    \"coolstuffinc_price\": \"0.99\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 74298287,\n" +
            "            \"name\": \"Mermail Abyssdine\",\n" +
            "            \"typeline\": [\n" +
            "                \"Aqua\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Aqua\",\n" +
            "            \"atk\": 1000,\n" +
            "            \"def\": 200,\n" +
            "            \"level\": 3,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssdine-6245\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Cosmo Blazer\",\n" +
            "                    \"set_code\": \"CBLZ-EN032\",\n" +
            "                    \"set_rarity\": \"Super Rare\",\n" +
            "                    \"set_rarity_code\": \"(SR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 74298287,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/74298287.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/74298287.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/74298287.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"2.27\",\n" +
            "                    \"tcgplayer_price\": \"1.35\",\n" +
            "                    \"ebay_price\": \"1.98\",\n" +
            "                    \"amazon_price\": \"2.39\",\n" +
            "                    \"coolstuffinc_price\": \"0.99\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 74371660,\n" +
            "            \"name\": \"Mermail Abyssgaios\",\n" +
            "            \"typeline\": [\n" +
            "                \"Aqua\",\n" +
            "                \"Xyz\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"XYZ Monster\",\n" +
            "            \"humanReadableCardType\": \"Xyz Effect Monster\",\n" +
            "            \"frameType\": \"xyz\",\n" +
            "            \"race\": \"Aqua\",\n" +
            "            \"atk\": 2800,\n" +
            "            \"def\": 1600,\n" +
            "            \"level\": 7,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssgaios-6251\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN046\",\n" +
            "                    \"set_rarity\": \"Ultimate Rare\",\n" +
            "                    \"set_rarity_code\": \"(UtR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN046\",\n" +
            "                    \"set_rarity\": \"Ultra Rare\",\n" +
            "                    \"set_rarity_code\": \"(UR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 74371660,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/74371660.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/74371660.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/74371660.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"10.41\",\n" +
            "                    \"tcgplayer_price\": \"47.40\",\n" +
            "                    \"ebay_price\": \"10.99\",\n" +
            "                    \"amazon_price\": \"29.88\",\n" +
            "                    \"coolstuffinc_price\": \"0.00\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 69293721,\n" +
            "            \"name\": \"Mermail Abyssgunde\",\n" +
            "            \"typeline\": [\n" +
            "                \"Aqua\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Aqua\",\n" +
            "            \"atk\": 1400,\n" +
            "            \"def\": 800,\n" +
            "            \"level\": 3,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssgunde-5828\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN015\",\n" +
            "                    \"set_rarity\": \"Rare\",\n" +
            "                    \"set_rarity_code\": \"(R)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Astral Pack Three\",\n" +
            "                    \"set_code\": \"AP03-EN005\",\n" +
            "                    \"set_rarity\": \"Super Rare\",\n" +
            "                    \"set_rarity_code\": \"(SR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 69293721,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/69293721.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/69293721.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/69293721.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"1.84\",\n" +
            "                    \"tcgplayer_price\": \"0.89\",\n" +
            "                    \"ebay_price\": \"2.99\",\n" +
            "                    \"amazon_price\": \"0.91\",\n" +
            "                    \"coolstuffinc_price\": \"0.99\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 96682430,\n" +
            "            \"name\": \"Mermail Abysshilde\",\n" +
            "            \"typeline\": [\n" +
            "                \"Aqua\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Aqua\",\n" +
            "            \"atk\": 1300,\n" +
            "            \"def\": 400,\n" +
            "            \"level\": 3,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abysshilde-8045\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN016\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 96682430,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/96682430.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/96682430.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/96682430.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.13\",\n" +
            "                    \"tcgplayer_price\": \"0.23\",\n" +
            "                    \"ebay_price\": \"1.74\",\n" +
            "                    \"amazon_price\": \"0.39\",\n" +
            "                    \"coolstuffinc_price\": \"0.39\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 37781520,\n" +
            "            \"name\": \"Mermail Abyssleed\",\n" +
            "            \"typeline\": [\n" +
            "                \"Sea Serpent\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Sea Serpent\",\n" +
            "            \"atk\": 2700,\n" +
            "            \"def\": 1000,\n" +
            "            \"level\": 7,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssleed-3198\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Cosmo Blazer\",\n" +
            "                    \"set_code\": \"CBLZ-EN034\",\n" +
            "                    \"set_rarity\": \"Secret Rare\",\n" +
            "                    \"set_rarity_code\": \"(ScR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Shadows in Valhalla\",\n" +
            "                    \"set_code\": \"SHVA-EN038\",\n" +
            "                    \"set_rarity\": \"Super Rare\",\n" +
            "                    \"set_rarity_code\": \"(SR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 37781520,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/37781520.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/37781520.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/37781520.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.26\",\n" +
            "                    \"tcgplayer_price\": \"0.20\",\n" +
            "                    \"ebay_price\": \"3.34\",\n" +
            "                    \"amazon_price\": \"0.25\",\n" +
            "                    \"coolstuffinc_price\": \"0.49\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 23899727,\n" +
            "            \"name\": \"Mermail Abysslinde\",\n" +
            "            \"typeline\": [\n" +
            "                \"Aqua\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Aqua\",\n" +
            "            \"atk\": 1500,\n" +
            "            \"def\": 1200,\n" +
            "            \"level\": 3,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abysslinde-2060\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN014\",\n" +
            "                    \"set_rarity\": \"Ultimate Rare\",\n" +
            "                    \"set_rarity_code\": \"(UtR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN014\",\n" +
            "                    \"set_rarity\": \"Ultra Rare\",\n" +
            "                    \"set_rarity_code\": \"(UR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 23899727,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/23899727.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/23899727.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/23899727.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"10.84\",\n" +
            "                    \"tcgplayer_price\": \"15.14\",\n" +
            "                    \"ebay_price\": \"29.99\",\n" +
            "                    \"amazon_price\": \"12.99\",\n" +
            "                    \"coolstuffinc_price\": \"0.00\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 95466842,\n" +
            "            \"name\": \"Mermail Abysslung\",\n" +
            "            \"typeline\": [\n" +
            "                \"Fish\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Fish\",\n" +
            "            \"atk\": 1200,\n" +
            "            \"def\": 1800,\n" +
            "            \"level\": 4,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abysslung-7951\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN019\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 95466842,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/95466842.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/95466842.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/95466842.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.18\",\n" +
            "                    \"tcgplayer_price\": \"0.18\",\n" +
            "                    \"ebay_price\": \"0.99\",\n" +
            "                    \"amazon_price\": \"0.25\",\n" +
            "                    \"coolstuffinc_price\": \"0.25\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 21767650,\n" +
            "            \"name\": \"Mermail Abyssmander\",\n" +
            "            \"typeline\": [\n" +
            "                \"Fish\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Fish\",\n" +
            "            \"atk\": 100,\n" +
            "            \"def\": 2000,\n" +
            "            \"level\": 4,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssmander-1870\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN081\",\n" +
            "                    \"set_rarity\": \"Rare\",\n" +
            "                    \"set_rarity_code\": \"(R)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 21767650,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/21767650.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/21767650.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/21767650.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.45\",\n" +
            "                    \"tcgplayer_price\": \"0.32\",\n" +
            "                    \"ebay_price\": \"2.50\",\n" +
            "                    \"amazon_price\": \"0.59\",\n" +
            "                    \"coolstuffinc_price\": \"0.79\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 21954587,\n" +
            "            \"name\": \"Mermail Abyssmegalo\",\n" +
            "            \"typeline\": [\n" +
            "                \"Sea Serpent\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Sea Serpent\",\n" +
            "            \"atk\": 2400,\n" +
            "            \"def\": 1900,\n" +
            "            \"level\": 7,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssmegalo-1890\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN020\",\n" +
            "                    \"set_rarity\": \"Secret Rare\",\n" +
            "                    \"set_rarity_code\": \"(ScR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Battle Pack 2: War of the Giants\",\n" +
            "                    \"set_code\": \"BP02-EN117\",\n" +
            "                    \"set_rarity\": \"Mosaic Rare\",\n" +
            "                    \"set_rarity_code\": \"(MSR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Battle Pack 2: War of the Giants\",\n" +
            "                    \"set_code\": \"BP02-EN117\",\n" +
            "                    \"set_rarity\": \"Rare\",\n" +
            "                    \"set_rarity_code\": \"(R)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"OTS Tournament Pack 26\",\n" +
            "                    \"set_code\": \"OP26-EN015\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Shadows in Valhalla\",\n" +
            "                    \"set_code\": \"SHVA-EN037\",\n" +
            "                    \"set_rarity\": \"Super Rare\",\n" +
            "                    \"set_rarity_code\": \"(SR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 21954587,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/21954587.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/21954587.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/21954587.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.17\",\n" +
            "                    \"tcgplayer_price\": \"0.33\",\n" +
            "                    \"ebay_price\": \"2.69\",\n" +
            "                    \"amazon_price\": \"20.39\",\n" +
            "                    \"coolstuffinc_price\": \"0.49\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71133680,\n" +
            "            \"name\": \"Mermail Abyssnerei\",\n" +
            "            \"typeline\": [\n" +
            "                \"Aqua\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Aqua\",\n" +
            "            \"atk\": 1200,\n" +
            "            \"def\": 2000,\n" +
            "            \"level\": 3,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssnerei-8635\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"2018 Mega-Tin Mega Pack\",\n" +
            "                    \"set_code\": \"MP18-EN118\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Circuit Break\",\n" +
            "                    \"set_code\": \"CIBR-EN028\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 71133680,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/71133680.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/71133680.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/71133680.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.10\",\n" +
            "                    \"tcgplayer_price\": \"0.13\",\n" +
            "                    \"ebay_price\": \"0.99\",\n" +
            "                    \"amazon_price\": \"0.98\",\n" +
            "                    \"coolstuffinc_price\": \"0.25\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 282886,\n" +
            "            \"name\": \"Mermail Abyssnose\",\n" +
            "            \"typeline\": [\n" +
            "                \"Fish\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Fish\",\n" +
            "            \"atk\": 1500,\n" +
            "            \"def\": 1500,\n" +
            "            \"level\": 4,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssnose-28\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Cosmo Blazer\",\n" +
            "                    \"set_code\": \"CBLZ-EN033\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 282886,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/282886.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/282886.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/282886.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.16\",\n" +
            "                    \"tcgplayer_price\": \"0.14\",\n" +
            "                    \"ebay_price\": \"0.99\",\n" +
            "                    \"amazon_price\": \"0.25\",\n" +
            "                    \"coolstuffinc_price\": \"0.25\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 28577986,\n" +
            "            \"name\": \"Mermail Abyssocea\",\n" +
            "            \"typeline\": [\n" +
            "                \"Aqua\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Aqua\",\n" +
            "            \"atk\": 1100,\n" +
            "            \"def\": 1900,\n" +
            "            \"level\": 3,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssocea-2433\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"2014 Mega-Tin Mega Pack\",\n" +
            "                    \"set_code\": \"MP14-EN016\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Lord of the Tachyon Galaxy\",\n" +
            "                    \"set_code\": \"LTGY-EN030\",\n" +
            "                    \"set_rarity\": \"Common\",\n" +
            "                    \"set_rarity_code\": \"(C)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 28577986,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/28577986.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/28577986.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/28577986.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.17\",\n" +
            "                    \"tcgplayer_price\": \"0.15\",\n" +
            "                    \"ebay_price\": \"0.99\",\n" +
            "                    \"amazon_price\": \"0.25\",\n" +
            "                    \"coolstuffinc_price\": \"0.25\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 58471134,\n" +
            "            \"name\": \"Mermail Abysspike\",\n" +
            "            \"typeline\": [\n" +
            "                \"Fish\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Fish\",\n" +
            "            \"atk\": 1600,\n" +
            "            \"def\": 800,\n" +
            "            \"level\": 4,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abysspike-4970\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN018\",\n" +
            "                    \"set_rarity\": \"Rare\",\n" +
            "                    \"set_rarity_code\": \"(R)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Astral Pack Five\",\n" +
            "                    \"set_code\": \"AP05-EN007\",\n" +
            "                    \"set_rarity\": \"Super Rare\",\n" +
            "                    \"set_rarity_code\": \"(SR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 58471134,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/58471134.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/58471134.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/58471134.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"7.20\",\n" +
            "                    \"tcgplayer_price\": \"5.27\",\n" +
            "                    \"ebay_price\": \"6.94\",\n" +
            "                    \"amazon_price\": \"0.98\",\n" +
            "                    \"coolstuffinc_price\": \"0.99\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 22446869,\n" +
            "            \"name\": \"Mermail Abyssteus\",\n" +
            "            \"typeline\": [\n" +
            "                \"Aqua\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Aqua\",\n" +
            "            \"atk\": 1700,\n" +
            "            \"def\": 2400,\n" +
            "            \"level\": 7,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssteus-1930\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Battles of Legend: Light's Revenge\",\n" +
            "                    \"set_code\": \"BLLR-EN051\",\n" +
            "                    \"set_rarity\": \"Secret Rare\",\n" +
            "                    \"set_rarity_code\": \"(ScR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Cosmo Blazer\",\n" +
            "                    \"set_code\": \"CBLZ-EN083\",\n" +
            "                    \"set_rarity\": \"Ultimate Rare\",\n" +
            "                    \"set_rarity_code\": \"(UtR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Cosmo Blazer\",\n" +
            "                    \"set_code\": \"CBLZ-EN083\",\n" +
            "                    \"set_rarity\": \"Ultra Rare\",\n" +
            "                    \"set_rarity_code\": \"(UR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"set_name\": \"Shadows in Valhalla\",\n" +
            "                    \"set_code\": \"SHVA-EN039\",\n" +
            "                    \"set_rarity\": \"Super Rare\",\n" +
            "                    \"set_rarity_code\": \"(SR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 22446869,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/22446869.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/22446869.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/22446869.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.29\",\n" +
            "                    \"tcgplayer_price\": \"0.27\",\n" +
            "                    \"ebay_price\": \"0.09\",\n" +
            "                    \"amazon_price\": \"0.45\",\n" +
            "                    \"coolstuffinc_price\": \"0.49\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 59170782,\n" +
            "            \"name\": \"Mermail Abysstrite\",\n" +
            "            \"typeline\": [\n" +
            "                \"Sea Serpent\",\n" +
            "                \"Xyz\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"XYZ Monster\",\n" +
            "            \"humanReadableCardType\": \"Xyz Effect Monster\",\n" +
            "            \"frameType\": \"xyz\",\n" +
            "            \"race\": \"Sea Serpent\",\n" +
            "            \"atk\": 1600,\n" +
            "            \"def\": 2800,\n" +
            "            \"level\": 3,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abysstrite-5031\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Cosmo Blazer\",\n" +
            "                    \"set_code\": \"CBLZ-EN050\",\n" +
            "                    \"set_rarity\": \"Super Rare\",\n" +
            "                    \"set_rarity_code\": \"(SR)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 59170782,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/59170782.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/59170782.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/59170782.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"8.74\",\n" +
            "                    \"tcgplayer_price\": \"6.39\",\n" +
            "                    \"ebay_price\": \"2.19\",\n" +
            "                    \"amazon_price\": \"5.88\",\n" +
            "                    \"coolstuffinc_price\": \"1.49\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 22076135,\n" +
            "            \"name\": \"Mermail Abyssturge\",\n" +
            "            \"typeline\": [\n" +
            "                \"Fish\",\n" +
            "                \"Effect\"\n" +
            "            ],\n" +
            "            \"type\": \"Effect Monster\",\n" +
            "            \"humanReadableCardType\": \"Effect Monster\",\n" +
            "            \"frameType\": \"effect\",\n" +
            "            \"race\": \"Fish\",\n" +
            "            \"atk\": 1700,\n" +
            "            \"def\": 1100,\n" +
            "            \"level\": 4,\n" +
            "            \"attribute\": \"WATER\",\n" +
            "            \"archetype\": \"Mermail\",\n" +
            "            \"ygoprodeck_url\": \"https://ygoprodeck.com/card/mermail-abyssturge-1902\",\n" +
            "            \"card_sets\": [\n" +
            "                {\n" +
            "                    \"set_name\": \"Abyss Rising\",\n" +
            "                    \"set_code\": \"ABYR-EN017\",\n" +
            "                    \"set_rarity\": \"Rare\",\n" +
            "                    \"set_rarity_code\": \"(R)\",\n" +
            "                    \"set_price\": \"0\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_images\": [\n" +
            "                {\n" +
            "                    \"id\": 22076135,\n" +
            "                    \"image_url\": \"https://images.ygoprodeck.com/images/cards/22076135.jpg\",\n" +
            "                    \"image_url_small\": \"https://images.ygoprodeck.com/images/cards_small/22076135.jpg\",\n" +
            "                    \"image_url_cropped\": \"https://images.ygoprodeck.com/images/cards_cropped/22076135.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"card_prices\": [\n" +
            "                {\n" +
            "                    \"cardmarket_price\": \"0.48\",\n" +
            "                    \"tcgplayer_price\": \"0.48\",\n" +
            "                    \"ebay_price\": \"1.94\",\n" +
            "                    \"amazon_price\": \"0.59\",\n" +
            "                    \"coolstuffinc_price\": \"0.25\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static List<YGOCardDto> getTestCards(ObjectMapper mapper) throws JsonProcessingException {
        JsonNode node = mapper.readTree(PAYLOAD);
        String json = node.get("data").toString();
        return mapper.readValue(json,
                new TypeReference<List<com.mshindelar.collection.YGOPROApi.dto.YGOCardDto>>() {});
    }
}
