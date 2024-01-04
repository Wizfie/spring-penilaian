package example.penilaian.model.penilaianPresentasi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ScorePresentasiSummary {
    private String username;
    private String nip;
    private Date createdAt;
    private double totalPoints;
    private String teamName;
}
