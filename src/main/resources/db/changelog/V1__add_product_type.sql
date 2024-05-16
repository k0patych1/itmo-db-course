DO
$$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'product_type') THEN
            CREATE TYPE product_type AS ENUM
                (
                    'MEAT_AND_MEAT_PRODUCTS',
                    'FISH_AND_SEAFOOD',
                    'EGGS',
                    'MILK_AND_DAIRY_PRODUCTS',
                    'BREAD_AND_BAKERY_PRODUCTS',
                    'CEREALS_AND_PASTA',
                    'LEGUMES',
                    'VEGETABLES_FRUITS_AND_BERRIES',
                    'NUTS_AND_MUSHROOMS',
                    'CONFECTIONERY',
                    'FATS_AND_OILS',
                    'BEVERAGES');
        END IF;
    END
$$;