package qu.task.so.extractor.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserInfo {
    private String actionTime;
    private String userName;
    private Integer reputationScore;
    private Integer goldBadges;
    private Integer silverBadges;
    private Integer bronzeBadges;
}
