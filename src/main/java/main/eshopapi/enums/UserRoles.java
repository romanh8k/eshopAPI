package main.eshopapi.enums;

public enum UserRoles {

    VENDOR(0),
    CUSTOMER(1);

    private int role;

    private UserRoles(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}
