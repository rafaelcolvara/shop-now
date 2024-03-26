var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "54915",
        "ok": "284",
        "ko": "54631"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "102",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "60157",
        "ok": "59831",
        "ko": "60157"
    },
    "meanResponseTime": {
        "total": "43812",
        "ok": "32145",
        "ko": "43872"
    },
    "standardDeviation": {
        "total": "22060",
        "ok": "17651",
        "ko": "22064"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "34555",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "47663",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60005",
        "ok": "56464",
        "ko": "60005"
    },
    "percentiles4": {
        "total": "60032",
        "ok": "59397",
        "ko": "60033"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 9,
    "percentage": 0
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 2,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 273,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 54631,
    "percentage": 99
},
    "meanNumberOfRequestsPerSecond": {
        "total": "206.447",
        "ok": "1.068",
        "ko": "205.38"
    }
},
contents: {
"req_criac-a-o-ce502": {
        type: "REQUEST",
        name: "criação",
path: "criação",
pathFormatted: "req_criac-a-o-ce502",
stats: {
    "name": "criação",
    "numberOfRequests": {
        "total": "54631",
        "ok": "284",
        "ko": "54347"
    },
    "minResponseTime": {
        "total": "102",
        "ok": "102",
        "ko": "176"
    },
    "maxResponseTime": {
        "total": "60157",
        "ok": "59831",
        "ko": "60157"
    },
    "meanResponseTime": {
        "total": "43821",
        "ok": "32145",
        "ko": "43882"
    },
    "standardDeviation": {
        "total": "22034",
        "ok": "17651",
        "ko": "22039"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "34555",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "47663",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60005",
        "ok": "56464",
        "ko": "60005"
    },
    "percentiles4": {
        "total": "60032",
        "ok": "59397",
        "ko": "60032"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 9,
    "percentage": 0
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 2,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 273,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 54347,
    "percentage": 99
},
    "meanNumberOfRequestsPerSecond": {
        "total": "205.38",
        "ok": "1.068",
        "ko": "204.312"
    }
}
    },"req_consulta-5d76b": {
        type: "REQUEST",
        name: "consulta",
path: "consulta",
pathFormatted: "req_consulta-5d76b",
stats: {
    "name": "consulta",
    "numberOfRequests": {
        "total": "284",
        "ok": "0",
        "ko": "284"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "-",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "60062",
        "ok": "-",
        "ko": "60062"
    },
    "meanResponseTime": {
        "total": "42095",
        "ok": "-",
        "ko": "42095"
    },
    "standardDeviation": {
        "total": "26460",
        "ok": "-",
        "ko": "26460"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "-",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "-",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60013",
        "ok": "-",
        "ko": "60013"
    },
    "percentiles4": {
        "total": "60042",
        "ok": "-",
        "ko": "60042"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 284,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.068",
        "ok": "-",
        "ko": "1.068"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
