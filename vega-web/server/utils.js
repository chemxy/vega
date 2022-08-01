const DEBUG = true;

export async function debugLog(msg) {
    if (DEBUG) {
        console.log(msg);
    }
}

// module.exports = debugLog;