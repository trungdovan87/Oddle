let ENV = {
    DEV: "DEV",
    STAGE: "STAGE",
    LIVE: "LIVE"
}

const env = ENV.DEV;

export let HOST;

switch (env) {
    case ENV.DEV:
        HOST = 'http://localhost:8080'
        break;
    case ENV.STAGE:
        break;
    case ENV.LIVE:
        break;
    default:
        throw Error('Unknown Environment: ' + env);
}


