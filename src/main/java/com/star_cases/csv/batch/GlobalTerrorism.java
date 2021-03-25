package com.star_cases.csv.batch;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  globalterrorism database table representation
 *
 *  Actual data sourced from: https://www.kaggle.com/START-UMD/gtd
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GlobalTerrorism
{
    // This is populated by the item processor
    private UUID globalterrorism_id;

    private String addnotes;

    private String alternative;

    private String alternative_txt;

    private String approxdate;

    private Integer attacktype1;

    private String attacktype1_txt;

    private Integer attacktype2;

    private String attacktype2_txt;

    private Integer attacktype3;

    private String attacktype3_txt;

    private String city;

    private Integer claim2;

    private Integer claim3;

    private Integer claimed;

    private Integer claimmode;

    private String claimmode_txt;

    private Integer claimmode2;

    private String claimmode2_txt;

    private Integer claimmode3;

    private String claimmode3_txt;

    private String compclaim;

    private String corp1;

    private String corp2;

    private String corp3;

    private Integer country;

    private String country_txt;

    private String crit1;

    private String crit2;

    private String crit3;

    private String dbsource;

    private String divert;

    private Integer doubtterr;

    private Long eventid;

    private Boolean extended;

    private String gname;

    private String gname2;

    private String gname3;

    private String gsubname;

    private String gsubname2;

    private String gsubname3;

    private Integer guncertain1;

    private Integer guncertain2;

    private Integer guncertain3;

    private Integer hostkidoutcome;

    private String hostkidoutcome_txt;

    private Integer iday;

    private Integer imonth;

    private Integer individual;

    private Integer int_any;

    private Integer int_ideo;

    private Integer int_log;

    private Integer int_misc;

    private Integer ishostkid;

    private Integer iyear;

    private String kidhijcountry;

    private Double latitude;

    private String location;

    private Double longitude;

    private String motive;

    private Integer multiple;

    private Integer natlty1;

    private String natlty1_txt;

    private Integer natlty2;

    private String natlty2_txt;

    private Integer natlty3;

    private String natlty3_txt;

    private Integer ndays;

    private Integer nhostkid;

    private Integer nhostkidus;

    private Float nhours;

    private Integer nkill;

    private Integer nkillter;

    private Integer nkillus;

    private Float nperpcap;

    private Integer nperps;

    private Integer nreleased;

    private Float nwound;

    private Float nwoundte;

    private Float nwoundus;

    private String propcomment;

    private Integer property;

    private Integer propextent;

    private String propextent_txt;

    private Float propvalue;

    private String provstate;

    private Long ransom;

    private Float ransomamt;

    private Float ransomamtus;

    private String ransomnote;

    private Float ransompaid;

    private Float ransompaidus;

    private Integer region;

    private String region_txt;

    private String related;

    private String resolution;

    private String scite1;

    private String scite2;

    private String scite3;

    private Integer specificity;

    private Integer success;

    private Integer suicide;

    private String summary;

    private String target1;

    private String target2;

    private String target3;

    private Integer targsubtype1;

    private String targsubtype1_txt;

    private Integer targsubtype2;

    private String targsubtype2_txt;

    private Integer targsubtype3;

    private String targsubtype3_txt;

    private Integer targtype1;

    private String targtype1_txt;

    private Integer targtype2;

    private String targtype2_txt;

    private Integer targtype3;

    private String targtype3_txt;

    private Integer vicinity;

    private String weapdetail;

    private Integer weapsubtype1;

    private String weapsubtype1_txt;

    private Integer weapsubtype2;

    private String weapsubtype2_txt;

    private Integer weapsubtype3;

    private String weapsubtype3_txt;

    private Integer weapsubtype4;

    private String weapsubtype4_txt;

    private Integer weaptype1;

    private String weaptype1_txt;

    private Integer weaptype2;

    private String weaptype2_txt;

    private Integer weaptype3;

    private String weaptype3_txt;

    private Integer weaptype4;

    private String weaptype4_txt;
}
