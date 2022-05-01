package com.skyspecs.task2.entity;



import lombok.Data;
import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Table(name = "\"SemoDispatchDown\"")
@Entity
@NamedQuery(name = "SemoDispatchDownEntity.findDistinctResourceNames",
        query = "SELECT DISTINCT e.resourceName FROM SemoDispatchDownEntity e"
)
public class SemoDispatchDownEntity {

    @Id
    private Long id;
    @Column(name = "row_id")
    private String rowId;
    @Column(name = "qboa")
    private Double qboa;
    @Column(name = "trade_date")
    private String tradeDate;
    @Column(name = "start_time", columnDefinition = "TimeStamp")
    private Timestamp startTime;
    @Column(name = "end_time", columnDefinition = "TIMESTAMP")
    private Timestamp endTime;
    @Column(name = "updated_date")
    private String updateDate;
    @Column(name = "participant_name")
    private String participantName;
    @Column(name = "resource_name")
    private String resourceName;
    @Column(name = "pboa")
    private String pboa;
    @Column(name = "rank")
    private String rank;
    @Column(name = "so_flag")
    private String soFlag;
    @Column(name = "emergency_flag")
    private String emergencyFlag;
    @Column(name = "no_marginal_flag")
    private String noMarginalFlag;
    @Column(name = "imbalance_price_flag")
    private String imbalancePriceFlag;
    @Column(name = "net_imbalance_volume_tag")
    private String netImbalanceVolumeTag;
    @Column(name = "imbalance_price_tag")
    private String imbalancePriceTag;
    @Column(name = "price_average_reference_tag")
    private String priceAverageReferenceTag;
    @Column(name = "net_imbalance_volume")
    private String netImbalanceVolume;
    @Column(name= "from_file")
    private  String fromFile;

    @Override
    public String toString() {
        return "SemoDispatchDownEntity{" +
                "id=" + id +
                ", qboa=" + qboa +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}