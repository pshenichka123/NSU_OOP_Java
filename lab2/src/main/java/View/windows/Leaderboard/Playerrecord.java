package Model.Leaderboard;

class PlayerRecord implements Comparable<PlayerRecord> {
    String nickname;
    int time;

    public PlayerRecord(String nickname, int time) {
        this.nickname = nickname;
        this.time = time;
    }

    @Override
    public int compareTo(PlayerRecord other) {
        return Integer.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return nickname + "," + time;
    }
}