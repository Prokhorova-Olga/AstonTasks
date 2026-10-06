package ru.aston.hometask;

import java.util.Objects;

public final class SafeUser {
    private final User user;

    public SafeUser(User source) {
        Objects.requireNonNull(source, "source must not be null");
        this.user = new User(source);
    }

    public User getUserCopy() {
        return new User(user);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SafeUser safeUser = (SafeUser) o;
        return Objects.equals(user, safeUser.user);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user);
    }

    @Override
    public String toString() {
        return "SafeUser{" +
                "user=" + user +
                '}';
    }
}
