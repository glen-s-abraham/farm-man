-- Enum type for System Type
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'system_type') THEN
        CREATE TYPE system_type AS ENUM (
            'Nutrient Film Technique (NFT)',
            'Deep Water Culture (DWC)',
            'Ebb and Flow (Flood and Drain)',
            'Aeroponics',
            'Drip System (Top Feed)',
            'Wick System',
            'Aquaponics',
            'Hybrid Systems',
            'Vertical Hydroponics',
            'Kratky Method'
        );
    END IF;
END$$;

-- Table creation script
CREATE TABLE IF NOT EXISTS hydroponic_systems (
    id SERIAL PRIMARY KEY,
    location VARCHAR(255) NOT NULL,
    system_type system_type NOT NULL,
    installation_date DATE NOT NULL,
    capacity INT NOT NULL CHECK (capacity > 0),
    CONSTRAINT unique_system_location UNIQUE (location)
);

-- Explanation and logic:
-- id: A unique identifier for each entry. Using SERIAL to auto-increment.
-- location: Stores the physical location within the facility, ensuring it's not null.
-- system_type: An enumerated type to ensure that only predefined system types are stored.
-- installation_date: Stores the date when the system was installed. Only dates are stored to maintain consistency.
-- capacity: Number of plants that the system can support. Must be greater than 0, ensuring logical data.
-- The unique constraint on location ensures that no two systems have the same location within the database.