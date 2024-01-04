package example.penilaian.repository.presentasi;

import example.penilaian.entity.presentasi.Score;
import example.penilaian.model.penilaianPresentasi.ScorePresentasiSummary;
import example.penilaian.model.penilaianYelyel.PointDataSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score , Integer> {



    Optional<Score> findByTitleAndUsernameAndTeamNameAndCreatedAt(String title, String username, String teamName, Date createdAt);

    List<Score> findAllByNip(String nip);


    List<Score> findByNipAndCreatedAt(String nip, LocalDate createdAt);

    Page<Score> findAll(Specification<Score> spec, Pageable pageRequest);

    @Query("SELECT new example.penilaian.model.penilaianPresentasi.ScorePresentasiSummary(pd.username, pd.nip, pd.createdAt, CAST(SUM(pd.score) AS double), pd.teamName) " +
            "FROM Score pd " +
            "WHERE (:usernameOrTeamName is null OR pd.username LIKE %:usernameOrTeamName% OR pd.teamName LIKE %:usernameOrTeamName%) " +
            "AND (:startDate is null OR pd.createdAt >= :startDate) " +
            "AND (:endDate is null OR pd.createdAt <= :endDate) " +
            "GROUP BY pd.username, pd.teamName, pd.createdAt, pd.nip")
    Page<ScorePresentasiSummary> getTotalScoreGroupedByUserAndTeamAndDate(
            @Param("usernameOrTeamName") String usernameOrTeamName,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate,
            Pageable pageable);


}

