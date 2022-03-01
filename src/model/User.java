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
    private int countWrappedBrush;

    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        setHighScore(0);
        setWallet(100);
        this.countLollipopHammer = 0;
        this.countExtraMoves = 0;
        this.countColourBomb = 0;
        this.countFreeSwitch = 0;
        this.countStripedBrush = 0;
        this.countWrappedBrush = 0;
    }

    public int getCountLollipopHammer() {
        return countLollipopHammer;
    }

    public void increaseCountLollipopHammer(int count) {
        countLollipopHammer += count;
    }

    public void decreaseCountLollipopHammer() {
        countLollipopHammer--;
    }

    public int getCountExtraMoves() {
        return countExtraMoves;
    }

    public void increaseCountExtraMoves(int count) {
        countExtraMoves += count;
    }

    public void decreaseCountExtraMoves() {
        countExtraMoves--;
    }

    public int getCountColourBomb() {
        return countColourBomb;
    }

    public void increaseCountColourBomb(int count) {
        this.countColourBomb += count;
    }

    public void decreaseCountColourBomb() {
        this.countColourBomb--;
    }

    public int getCountFreeSwitch() {
        return countFreeSwitch;
    }

    public void increaseCountFreeSwitch(int count) {
        this.countFreeSwitch += count;
    }

    public void decreaseCountFreeSwitch() {
        this.countFreeSwitch--;
    }

    public int getCountStripedBrush() {
        return countStripedBrush;
    }

    public void increaseCountStripedBrush(int count) {
        this.countStripedBrush += count;
    }

    public void decreaseCountStripedBrush() {
        this.countStripedBrush--;
    }

    public int getCountWrappedBrush() {
        return countStripedBrush;
    }

    public void increaseCountWrappedBrush(int count) {
        this.countWrappedBrush += count;
    }

    public void decreaseCountWrappedBrush() {
        this.countWrappedBrush--;
    }


    public void decreaseMoney(long cost) {
        wallet -= cost;
    }

    public void increaseMoney(long amount) {
        wallet += amount;
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
