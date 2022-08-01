DEBUG = false;

function debugLog(msg) {
    if (DEBUG) {
        console.log(msg);
    }
}

module.exports = debugLog;