// Silence logs when in production env
const DEBUG = false;

export async function debugLog(msg) {
    if (DEBUG) {
        console.log(msg);
    }
}

// module.exports = debugLog;