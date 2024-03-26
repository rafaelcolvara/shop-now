var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "54887",
        "ok": "266",
        "ko": "54621"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "75",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "60104",
        "ok": "59993",
        "ko": "60104"
    },
    "meanResponseTime": {
        "total": "42666",
        "ok": "30211",
        "ko": "42726"
    },
    "standardDeviation": {
        "total": "22440",
        "ok": "19777",
        "ko": "22436"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "31774",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "49883",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60003",
        "ok": "57612",
        "ko": "60003"
    },
    "percentiles4": {
        "total": "60011",
        "ok": "59743",
        "ko": "60011"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 19,
    "percentage": 0
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 3,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 244,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 54621,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "206.342",
        "ok": "1",
        "ko": "205.342"
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
        "total": "54621",
        "ok": "266",
        "ko": "54355"
    },
    "minResponseTime": {
        "total": "38",
        "ok": "75",
        "ko": "38"
    },
    "maxResponseTime": {
        "total": "60104",
        "ok": "59993",
        "ko": "60104"
    },
    "meanResponseTime": {
        "total": "42696",
        "ok": "30211",
        "ko": "42757"
    },
    "standardDeviation": {
        "total": "22403",
        "ok": "19777",
        "ko": "22398"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "31774",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "49883",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60003",
        "ok": "57612",
        "ko": "60003"
    },
    "percentiles4": {
        "total": "60011",
        "ok": "59743",
        "ko": "60011"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 19,
    "percentage": 0
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 3,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 244,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 54355,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "205.342",
        "ok": "1",
        "ko": "204.342"
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
        "total": "266",
        "ok": "0",
        "ko": "266"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "60010",
        "ok": "-",
        "ko": "60010"
    },
    "meanResponseTime": {
        "total": "36478",
        "ok": "-",
        "ko": "36478"
    },
    "standardDeviation": {
        "total": "28506",
        "ok": "-",
        "ko": "28506"
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
        "total": "60002",
        "ok": "-",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60004",
        "ok": "-",
        "ko": "60004"
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
    "count": 266,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1",
        "ok": "-",
        "ko": "1"
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
