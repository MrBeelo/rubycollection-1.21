package net.mrbeelo.rubycollection.java_by_kaupenjoe.J26Generics;

public class J26Pair<X, Y> {
    private X first;
    private Y second;

    public J26Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getFirst() {
        return first;
    }

    public void setFirst(X first) {
        this.first = first;
    }

    public Y getSecond() {
        return second;
    }

    public void setSecond(Y second) {
        this.second = second;
    }
}
