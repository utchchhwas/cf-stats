
package com.cfstats.submissions;

import com.cfstats.problemset.Problem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Raw submission returned by the API
public class Submission {

    @SerializedName("id")
    @Expose
    public long submissionId; // 	Integer.

    @SerializedName("contestId")
    @Expose
    public Long contestId; // 	Integer. Can be absent

    @SerializedName("creationTimeSeconds")
    @Expose
    public long creationTimeSeconds; // 	Integer. Time, when submission was created, in unix-format

    @SerializedName("relativeTimeSeconds")
    @Expose
    public long relativeTimeSeconds; // Integer. Number of seconds, passed after the start of the contest (or a virtual start for virtual parties), before the submission.

    @SerializedName("problem")
    @Expose
    public Problem problem; // Integer. Number of seconds, passed after the start of the contest (or a virtual start for virtual parties), before the submission.

//    @SerializedName("author")
//    @Expose
//    public Party author; // 	Party object.

    @SerializedName("programmingLanguage")
    @Expose
    public String programmingLanguage; // String.

    @SerializedName("verdict")
    @Expose
    public Verdict verdict; // 	Enum: FAILED, OK, PARTIAL, COMPILATION_ERROR, RUNTIME_ERROR, WRONG_ANSWER, PRESENTATION_ERROR, TIME_LIMIT_EXCEEDED, MEMORY_LIMIT_EXCEEDED, IDLENESS_LIMIT_EXCEEDED, SECURITY_VIOLATED, CRASHED, INPUT_PREPARATION_CRASHED, CHALLENGED, SKIPPED, TESTING, REJECTED. Can be absent

//    @SerializedName("testset")
//    @Expose
//    public String testset; // 	Enum: SAMPLES, PRETESTS, TESTS, CHALLENGES, TESTS1, ..., TESTS10. Testset used for judging the submission
//
//    @SerializedName("passedTestCount")
//    @Expose
//    public Long passedTestCount; // 	Integer. Number of passed tests.
//
//    @SerializedName("timeConsumedMillis")
//    @Expose
//    public Long timeConsumedMillis; // Integer. Maximum time in milliseconds, consumed by solution for one test
//
//    @SerializedName("memoryConsumedBytes")
//    @Expose
//    public Long memoryConsumedBytes; // Integer. Maximum memory in bytes, consumed by solution for one test.

//    @SerializedName("points")
//    @Expose
//    public Double points; // Floating point number. Can be absent. Number of scored points for IOI-like contests.

    public Problem getProblem() {
        return problem;
    }

    public Verdict getVerdict() {
        return verdict;
    }

}
