package org.example;

public final class SafeUser {
    private final User user;

    public SafeUser(User source) {
        this.user = new User(source);
    }

    public User getUserCopy() {
        return user;
    }

    @Override
    public String toString() {
        return "SafeUser{" +
                "user=" + user +
                '}';
    }
}
