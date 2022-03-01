package model;

public class User {

    private String username;
    private String password;
    private String nickname;

    private long highScore;
    private long wallet;
    private int countLollipopHammer;
    private int countExtraMoves;
    private int countColourBomb;
    private int countFreeSwitch;
    private int countStripedBrush;

    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        setHighScore(0);
        setWallet(0);
        this.countLollipopHammer = 0;
        this.countExtraMoves = 0;
        this.countColourBomb = 0;
        this.countFreeSwitch = 0;
        this.countStripedBrush = 0;
    }

    public int getCountLollipopHammer() {
        return countLollipopHammer;
    }

    public void increaseCountLollipopHammer(int count) {
        countLollipopHammer += count;
    }

    public void decreaseCountLollipopHammer(int count) {
        countLollipopHammer -= count;
    }

    public int getCountExtraMoves() {
        return countExtraMoves;
    }

    public void increaseCountExtraMoves(int count) {
        countExtraMoves += count;
    }

    public void decreaseCountExtraMoves(int count) {
        countExtraMoves -= count;
    }

    public int getCountColourBomb() {
        return countColourBomb;
    }

    public void increaseCountColourBomb(int count) {
        this.countColourBomb += count;
    }

    public void decreaseCountColourBomb(int count) {
        this.countColourBomb -= count;
    }

    public int getCountFreeSwitch() {
        return countFreeSwitch;
    }

    public void increaseCountFreeSwitch(int count) {
        this.countFreeSwitch += count;
    }

    public void decreaseCountFreeSwitch(int count) {
        this.countFreeSwitch -= count;
    }

    public int getCountStripedBrush() {
        return countStripedBrush;
    }

    public void increaseCountStripedBrush(int count) {
        this.countStripedBrush += count;
    }

    public void decreaseCountStripedBrush(int count) {
        this.countStripedBrush -= count;
    }

    public void decreaseMoney(long amount) {
        wallet += amount;
    }

    public void increaseMoney(long cost) {
        wallet -= cost;
    }

    public long getHighScore() {
        return highScore;
    }

    public void setHighScore(long highScore) {
        this.highScore = highScore;
    }

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}
