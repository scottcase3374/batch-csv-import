package com.star_cases.csv.batch;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *  globalterrorism database table representation
 *
 *  Actual data sourced from: https://www.kaggle.com/START-UMD/gtd
 *
 */
@Entity
@Table(name = "global_terrorism")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GlobalTerrorism
{
	@Id
    // This is populated by the item processor
    private UUID globalterrorism_id;

	@Column(length = 2500)
    private String addnotes;

	@Column(length = 300)
    private String alternative;

	@Column(length = 299)
    private String alternative_txt;

	@Column(length = 298)
    private String approxdate;

    private Integer attacktype1 = -1;

    @Column(length = 297)
    private String attacktype1_txt;

    private Integer attacktype2 = -1;

    @Column(length = 296)
    private String attacktype2_txt;

    private Integer attacktype3 = -1;

    @Column(length = 295)
    private String attacktype3_txt;

    @Column(length = 294)
    private String city;

    private Integer claim2 = -1;

    private Integer claim3 = -1;

    private Integer claimed = -1;

    private Integer claimmode = -1;

    @Column(length = 293)
    private String claimmode_txt;

    private Integer claimmode2 = -1;

    @Column(length = 292)
    private String claimmode2_txt;

    @Column(length = 291)
    private Integer claimmode3 = -1;

    @Column(length = 290)
    private String claimmode3_txt;

    @Column(length = 289)
    private String compclaim;

    @Column(length = 2500)
    private String corp1;

    @Column(length = 2500)
    private String corp2;

    @Column(length = 2500)
    private String corp3;

    private Integer country = -1;

    @Column(length = 287)
    private String country_txt;

    @Column(length = 286)
    private String crit1;

    @Column(length = 285)
    private String crit2;

    @Column(length = 284)
    private String crit3;

    @Column(length = 283)
    private String dbsource;

    @Column(length = 282)
    private String divert;

    private Integer doubtterr = -1;

    private Long eventid = -1L;

    private Boolean extended;

    @Column(length = 281)
    private String gname;

    @Column(length = 280)
    private String gname2;

    @Column(length = 279)
    private String gname3;

    @Column(length = 278)
    private String gsubname;

    @Column(length = 277)
    private String gsubname2;

    @Column(length = 276)
    private String gsubname3;

    private Integer guncertain1 = -1;

    private Integer guncertain2 = -1;

    private Integer guncertain3 = -1;

    private Integer hostkidoutcome = -1;

    @Column(length = 275)
    private String hostkidoutcome_txt;

    private Integer iday = -1;

    private Integer imonth = -1;

    private Integer individual = -1;

    private Integer int_any = -1;

    private Integer int_ideo = -1;

    private Integer int_log = -1;

    private Integer int_misc = -1;

    private Integer ishostkid = -1;

    private Integer iyear = -1;

    @Column(length = 274)
    private String kidhijcountry;

    private Double latitude = Double.NEGATIVE_INFINITY;

    @Column(length = 2500)
    private String location;

    private Double longitude = Double.NEGATIVE_INFINITY;

    @Column(length = 2500)
    private String motive;

    private Integer multiple = -1;

    private Integer natlty1 = -1;

    @Column(length = 272)
    private String natlty1_txt;

    private Integer natlty2 = -1;

    @Column(length = 271)
    private String natlty2_txt;

    private Integer natlty3 = -1;

    @Column(length = 270)
    private String natlty3_txt;

    private Integer ndays = -1;

    private Integer nhostkid = -1;

    private Integer nhostkidus = -1;

    private Float nhours = Float.NaN;

    private Integer nkill = -1;

    private Integer nkillter = -1;

    private Integer nkillus = -1;

    private Float nperpcap = Float.NaN;

    private Integer nperps = -1;

    private Integer nreleased = -1;

    private Float nwound = Float.NaN;

    private Float nwoundte = Float.NaN;

    private Float nwoundus = Float.NaN;

    @Column(length = 2500)
    private String propcomment;

    private Integer property = -1;

    private Integer propextent = -1;

    @Column(length = 269)
    private String propextent_txt;

    private Float propvalue = Float.NaN;

    @Column(length = 268)
    private String provstate;

    private Long ransom = -1L;

    private Float ransomamt = Float.NaN;

    private Float ransomamtus = Float.NaN;

    @Column(length = 2500)
    private String ransomnote;

    private Float ransompaid = Float.NaN;

    private Float ransompaidus = Float.NaN;

    private Integer region = -1;

    @Column(length = 267)
    private String region_txt;

    @Column(length = 2500)
    private String related;

    @Column(length = 2500)
    private String resolution;

    @Column(length = 2500)
    private String scite1;

    @Column(length = 2500)
    private String scite2;

    @Column(length = 2500)
    private String scite3;

    private Integer specificity = -1;

    private Integer success = -1;

    private Integer suicide = -1;

    @Column(length = 2500)
    private String summary;

    @Column(length = 2500)
    private String target1;

    @Column(length = 2500)
    private String target2;

    @Column(length = 2500)
    private String target3;

    private Integer targsubtype1 = -1;

    @Column(length = 266)
    private String targsubtype1_txt;

    private Integer targsubtype2 = -1;

    @Column(length = 265)
    private String targsubtype2_txt;

    private Integer targsubtype3 = -1;

    @Column(length = 264)
    private String targsubtype3_txt;

    private Integer targtype1 = -1;

    @Column(length = 263)
    private String targtype1_txt;

    private Integer targtype2 = -1;

    @Column(length = 262)
    private String targtype2_txt;

    private Integer targtype3 = -1;

    @Column(length = 261)
    private String targtype3_txt;

    private Integer vicinity = -1;

    @Column(length = 2500)
    private String weapdetail;

    private Integer weapsubtype1 = -1;

    @Column(length = 260)
    private String weapsubtype1_txt;

    private Integer weapsubtype2 = -1;

    @Column(length = 259)
    private String weapsubtype2_txt;

    private Integer weapsubtype3 = -1;

    @Column(length = 258)
    private String weapsubtype3_txt;

    private Integer weapsubtype4 = -1;

    @Column(length = 257)
    private String weapsubtype4_txt;

    private Integer weaptype1 = -1;

    @Column(length = 256)
    private String weaptype1_txt;

    private Integer weaptype2 = -1;

    @Column(length = 255)
    private String weaptype2_txt;

    private Integer weaptype3 = -1;

    @Column(length = 254)
    private String weaptype3_txt;

    private Integer weaptype4 = -1;

    @Column(length = 253)
    private String weaptype4_txt;
}
