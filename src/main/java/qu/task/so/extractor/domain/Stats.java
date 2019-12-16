package qu.task.so.extractor.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Stats {
    private Integer votes;
    private Integer answers;
    private Integer views;
}
