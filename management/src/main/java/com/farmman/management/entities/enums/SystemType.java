package com.farmman.management.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// public enum SystemType {
//     NUTRIENT_FILM_TECHNIQUE_NFT("Nutrient Film Technique (NFT)"),
//     DEEP_WATER_CULTURE_DWC("Deep Water Culture (DWC)"),
//     EBB_AND_FLOW_FLOOD_AND_DRAIN("Ebb and Flow (Flood and Drain)"),
//     AEROPONICS("Aeroponics"),
//     DRIP_SYSTEM_TOP_FEED("Drip System (Top Feed)"),
//     WICK_SYSTEM("Wick System"),
//     AQUAPONICS("Aquaponics"),
//     HYBRID_SYSTEMS("Hybrid Systems"),
//     VERTICAL_HYDROPONICS("Vertical Hydroponics"),
//     KRATKY_METHOD("Kratky Method");

//     private final String description;

//     SystemType(String description) {
//         this.description = description;
//     }

//     @Override
//     public String toString() {
//         return this.description;
//     }

//     // Implement a method that returns the enum from the string value
//     public static SystemType fromString(String description) {
//         for (SystemType b : SystemType.values()) {
//             if (b.description.equalsIgnoreCase(description)) {
//                 return b;
//             }
//         }
//         throw new IllegalArgumentException("No constant with text " + description + " found");
//     }

//     @JsonCreator // This is the method that will do the matching
//     public static SystemType forValue(String value) {
//         for (SystemType type : SystemType.values()) {
//             if (type.getDescription().equals(value)) {
//                 return type;
//             }
//         }
//         throw new IllegalArgumentException("No constant with description " + value + " found");
//     }

//     @JsonValue // This tells Jackson what to use when serializing the enum
//     public String getDescription() {
//         return this.description;
//     }
// }

public enum SystemType {
    NUTRIENT_FILM_TECHNIQUE,
    DEEP_WATER_CULTURE,
    EBB_AND_FLOW,
    AEROPONICS,
    DRIP_SYSTEM,
    WICK_SYSTEM,
    AQUAPONICS,
    HYBRID_SYSTEMS,
    VERTICAL_HYDROPONICS,
    KRATKY_METHOD
}