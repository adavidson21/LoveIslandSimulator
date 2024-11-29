package com.loveislandsimulator.enums;

public enum Role {
    REBEL,
    SURVIVOR,
    FLIRT,
    LEADER;

    /**
     * Gets the user-friendly role name from the role enum.
     *
     * @param role The role.
     * @return The name of the role.
     */
    public static String getRoleName(Role role){
        return switch (role) {
            case Role.SURVIVOR -> "Survivor";
            case Role.FLIRT -> "Flirt";
            case Role.LEADER -> "Leader";
            case Role.REBEL -> "Rebel";
        };
    }
}
