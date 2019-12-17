package qu.task.so.extractor.domain;

public class UserInfo {
    private String actionTime;
    private String userName;
    private String reputationScore;
    private Integer goldBadges;
    private Integer silverBadges;
    private Integer bronzeBadges;

    protected UserInfo() {
    }

    public UserInfo(String actionTime, String userName, String reputationScore, Integer goldBadges, Integer silverBadges, Integer bronzeBadges) {
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

    public String getUserName() {
        return userName;
    }

    public String getReputationScore() {
        return reputationScore;
    }

    public Integer getGoldBadges() {
        return goldBadges;
    }

    public Integer getSilverBadges() {
        return silverBadges;
    }

    public Integer getBronzeBadges() {
        return bronzeBadges;
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
