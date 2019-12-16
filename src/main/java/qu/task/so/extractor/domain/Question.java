package qu.task.so.extractor.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Question implements Serializable {
    private Stats stats;
    private String title;
    private String shortBody;
    private List<Tag> tags;
    private List<UserInfo> userInfos;
}
