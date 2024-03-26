var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "54927",
        "ok": "302",
        "ko": "54625"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "97",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "60483",
        "ok": "59755",
        "ko": "60483"
    },
    "meanResponseTime": {
        "total": "42826",
        "ok": "29380",
        "ko": "42901"
    },
    "standardDeviation": {
        "total": "22229",
        "ok": "18152",
        "ko": "22227"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "28053",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "46691",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60005",
        "ok": "56400",
        "ko": "60005"
    },
    "percentiles4": {
        "total": "60038",
        "ok": "58702",
        "ko": "60038"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 11,
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
    "count": 289,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 54625,
    "percentage": 99
},
    "meanNumberOfRequestsPerSecond": {
        "total": "206.492",
        "ok": "1.135",
        "ko": "205.357"
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
        "total": "54625",
        "ok": "302",
        "ko": "54323"
    },
    "minResponseTime": {
        "total": "58",
        "ok": "97",
        "ko": "58"
    },
    "maxResponseTime": {
        "total": "60483",
        "ok": "59755",
        "ko": "60483"
    },
    "meanResponseTime": {
        "total": "42845",
        "ok": "29380",
        "ko": "42920"
    },
    "standardDeviation": {
        "total": "22195",
        "ok": "18152",
        "ko": "22193"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "28053",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "46691",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60005",
        "ok": "56400",
        "ko": "60005"
    },
    "percentiles4": {
        "total": "60038",
        "ok": "58702",
        "ko": "60038"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 11,
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
    "count": 289,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 54323,
    "percentage": 99
},
    "meanNumberOfRequestsPerSecond": {
        "total": "205.357",
        "ok": "1.135",
        "ko": "204.222"
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
        "total": "302",
        "ok": "0",
        "ko": "302"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "-",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "60093",
        "ok": "-",
        "ko": "60093"
    },
    "meanResponseTime": {
        "total": "39500",
        "ok": "-",
        "ko": "39500"
    },
    "standardDeviation": {
        "total": "27503",
        "ok": "-",
        "ko": "27503"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "-",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "-",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60004",
        "ok": "-",
        "ko": "60004"
    },
    "percentiles4": {
        "total": "60010",
        "ok": "-",
        "ko": "60010"
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
    "count": 302,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.135",
        "ok": "-",
        "ko": "1.135"
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
