DO
$$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'measure') THEN
            CREATE TYPE measure AS ENUM (
                'KILOGRAMS',
                'GRAMS',
                'LITERS',
                'MILLILITERS',
                'PIECES',
                'PACKAGES',
                'BOXES',
                'BOTTLES',
                'CANS'
                );
        END IF;
    END
$$;