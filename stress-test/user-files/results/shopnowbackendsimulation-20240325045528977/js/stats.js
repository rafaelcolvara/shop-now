var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "54894",
        "ok": "268",
        "ko": "54626"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "72",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "60082",
        "ok": "59511",
        "ko": "60082"
    },
    "meanResponseTime": {
        "total": "41300",
        "ok": "29132",
        "ko": "41360"
    },
    "standardDeviation": {
        "total": "22370",
        "ok": "17784",
        "ko": "22374"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "30917",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "45238",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60003",
        "ok": "54532",
        "ko": "60003"
    },
    "percentiles4": {
        "total": "60008",
        "ok": "58900",
        "ko": "60008"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 26,
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
    "count": 242,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 54626,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "206.368",
        "ok": "1.008",
        "ko": "205.361"
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
        "total": "54626",
        "ok": "268",
        "ko": "54358"
    },
    "minResponseTime": {
        "total": "33",
        "ok": "72",
        "ko": "33"
    },
    "maxResponseTime": {
        "total": "60082",
        "ok": "59511",
        "ko": "60082"
    },
    "meanResponseTime": {
        "total": "41319",
        "ok": "29132",
        "ko": "41379"
    },
    "standardDeviation": {
        "total": "22334",
        "ok": "17784",
        "ko": "22338"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "30917",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "45238",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60003",
        "ok": "54532",
        "ko": "60003"
    },
    "percentiles4": {
        "total": "60008",
        "ok": "58900",
        "ko": "60008"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 26,
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
    "count": 242,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 54358,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "205.361",
        "ok": "1.008",
        "ko": "204.353"
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
        "total": "268",
        "ok": "0",
        "ko": "268"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "-",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "60019",
        "ok": "-",
        "ko": "60019"
    },
    "meanResponseTime": {
        "total": "37478",
        "ok": "-",
        "ko": "37478"
    },
    "standardDeviation": {
        "total": "28410",
        "ok": "-",
        "ko": "28410"
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
        "total": "60001",
        "ok": "-",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60003",
        "ok": "-",
        "ko": "60003"
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
    "count": 268,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.008",
        "ok": "-",
        "ko": "1.008"
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
