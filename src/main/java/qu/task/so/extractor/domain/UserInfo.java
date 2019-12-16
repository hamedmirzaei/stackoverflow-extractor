package qu.task.so.extractor.domain;

public class UserInfo {
    private String actionTime;
    private String userName;
    private Integer reputationScore;
    private Integer goldBadges;
    private Integer silverBadges;
    private Integer bronzeBadges;

    public UserInfo() {
    }

    public UserInfo(String actionTime, String userName, Integer reputationScore, Integer goldBadges, Integer silverBadges, Integer bronzeBadges) {
        this.actionTime = actionTime;
        this.userName = userName;
        this.reputationScore = reputationScore;
        this.goldBadges = goldBadges;
        this.silverBadges = silverBadges;
        this.bronzeBadges = bronzeBadges;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getReputationScore() {
        return reputationScore;
    }

    public void setReputationScore(Integer reputationScore) {
        this.reputationScore = reputationScore;
    }

    public Integer getGoldBadges() {
        return goldBadges;
    }

    public void setGoldBadges(Integer goldBadges) {
        this.goldBadges = goldBadges;
    }

    public Integer getSilverBadges() {
        return silverBadges;
    }

    public void setSilverBadges(Integer silverBadges) {
        this.silverBadges = silverBadges;
    }

    public Integer getBronzeBadges() {
        return bronzeBadges;
    }

    public void setBronzeBadges(Integer bronzeBadges) {
        this.bronzeBadges = bronzeBadges;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "actionTime='" + actionTime + '\'' +
                ", userName='" + userName + '\'' +
                ", reputationScore=" + reputationScore +
                ", goldBadges=" + goldBadges +
                ", silverBadges=" + silverBadges +
                ", bronzeBadges=" + bronzeBadges +
                '}';
    }
}
