
package com.cfstats.submissions;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Represents a party, participating in a contest.
public class Party {

    @SerializedName("contestId")
    @Expose
    public Long contestId; // 	Integer. Can be absent. Id of the contest, in which party is participating.

    @SerializedName("members")
    @Expose
    public List<Member> members = null; // List of Member objects. Members of the party.

    @SerializedName("participantType")
    @Expose
    public String participantType; // Enum: CONTESTANT, PRACTICE, VIRTUAL, MANAGER, OUT_OF_COMPETITION.

    @SerializedName("ghost")
    @Expose
    public Boolean ghost; // Boolean. If true then this party is a ghost. It participated in the contest, but not on Codeforces. For example, Andrew Stankevich Contests in Gym has ghosts of the participants from Petrozavodsk Training Camp.

    @SerializedName("startTimeSeconds")
    @Expose
    public Long startTimeSeconds; // Integer. Can be absent. Time, when this party started a contest.

//    @SerializedName("teamId")
//    @Expose
//    public String teamId; // Integer. Can be absent. If party is a team, then it is a unique team id. Otherwise, this field is absent.

//    @SerializedName("teamName")
//    @Expose
//    public String teamName; // String. Localized. Can be absent. If party is a team or ghost, then it is a localized name of the team. Otherwise, it is absent.

//    @SerializedName("room")
//    @Expose
//    public Long room; // Integer. Can be absent. Room of the party. If absent, then the party has no room.

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("contestId", contestId).append("members", members).append("participantType", participantType).append("ghost", ghost).append("startTimeSeconds", startTimeSeconds).toString();
    }

}
