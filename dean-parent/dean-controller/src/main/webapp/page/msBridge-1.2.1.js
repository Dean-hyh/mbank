var Fw = {
    // APP客户端版本号 '5.34' string
    appClientVersion: function (ua) {
        var t = ua.match(/cmbcc\sv\d*\.\d*/i);
        return (t || [""])[0].slice(7);
    }(navigator.userAgent),
    /**
     * 由客户端判断登不登录，登录后返回原页面执行回调
     * success即登录后需要执行的回调
     */
    afterLogin: function (param) {
        var cfg = {
            success: Fw.getFunctionName(param.success || function () {}),
            url: param.url || location.href,
            flag: param.flag || "0",
            dec: param.dec || "",
            btnName: param.btnName || "确定",
            forbidReload: param.forbidReload || true
        };
        Fw.Client.jumpToThird(cfg);
    },
    // 联名登录
    sendNewThirdLoginReq: function (param) {
        var cfg = {
            _isThirdLogin: param._isThirdLogin,
            // 由信用卡App提供
            params: param.params
        };
        Fw.Client.sendNewThirdLoginReq(cfg);
    },
    // 分享
    shareCmbcCredit: function (param, flag) {
        var cfg = {
            flag: flag || "1",
            //  1 有微博
            title: param.title || "民生信用卡",
            description: param.description || "推荐下载APP",
            image: param.image,
            url: param.url || "https://rs.creditcard.cmbc.com.cn/mbank/page/cardRecommended/downloadShare/share.html"
        };
        Fw.Client.shareCmbcCredit(cfg);
    },
    // 初始化标题栏
    initPageTitle: function (title, leftBtn, rightBtn) {
        if (typeof title === "string" && typeof leftBtn === "string" && typeof rightBtn === "string") {
            Fw.Client.initPageTitle(title, leftBtn, rightBtn);
        } else {
            console.error("initPageTitle格式错误");
        }
    },
    /**
     * 关闭当前activity(webView),返回上一个activity(webView)
     * 注意：此方法将被废除，此方法将被废除，此方法将被废除，请勿继续使用，请使用新方法：closeCurWebPanel替换
     */
    returnPage:function() {
        Fw.Client.returnPage();
    },
    // 直接回到APP首页（关闭所有web页）
    gotoIndex: function () {
        Fw.Client.gotoIndex();
    },
    // 去支付
    goPay: function (cfg) {
        Fw.Client.goPay(cfg);
    },
    // 显示标题栏
    showPageTitle: function (success) {
        if (Device.os === "android") {
            var cfg = {
                status: "visible",
                // for安卓
                success: Fw.getFunctionName(success || function () {})
            };
            Fw.Client.showPageTitle(cfg);
        }
    },
    // 隐藏标题栏
    hidenPageTitle: function (success) {
        var cfg = {
            status: "unvisible",
            // for安卓使用
            success: Fw.getFunctionName(success || function () {})
        };
        Fw.Client.hidenPageTitle(cfg);
    },
    // 禁止iOS的webview的bounce效果
    disableScroll: function () {
        Device.os === "iphone" && Fw.Client.disableScroll();
    },
    // 恢复iOS的webview的bounce效果
    enableScroll: function () {
        Device.os === "iphone" && Fw.Client.enableScroll();
    },

    // 开启新标签页
    openNewWebPanel: function (cfg) {
        Fw.Client.openNewWebPanel({
            url: cfg.url || ''
        });
    },

    //新UI扫一扫调native扫一扫相机
    newScan: function (targetUrl) {
        var cfg = {
            success: targetUrl
        }
        Fw.Client.newScan(cfg);
    },

    // 关闭当前标签页
    closeCurWebPanel: function () {
        Fw.Client.closeCurWebPanel();
    },

    // 获取定位
    getLocation: function (cfg, success) {
        cfg.success = Fw.getFunctionName(success);
        Fw.Client.getLocation(cfg);
    },
	thirdDreamValueQuery: function (cfg, success) {
        cfg.success = Fw.getFunctionName(success);
        Fw.Client.thirdDreamValueQuery(cfg);
    },
	thirdDreamValueSubStatus: function (cfg, success) {
        cfg.success = Fw.getFunctionName(success);
        Fw.Client.thirdDreamValueSubStatus(cfg);
    },
	thirdDreamValueSub: function (cfg, success) {
        cfg.success = Fw.getFunctionName(success);
        Fw.Client.thirdDreamValueSub(cfg);
    },
	thirdDreamValueAdd: function (cfg, success) {
        cfg.success = Fw.getFunctionName(success);
        Fw.Client.thirdDreamValueAdd(cfg);
    },

    //获取用户步数
    getStepCount: function (callback) { 
        var cfg = {
            callback: Fw.getFunctionName(callback)
        }
        Fw.Client.getStepCount(cfg)
    },


    idSeed: Date.now(),

    id: function () {
        return "fw_cb_" + Fw.idSeed++;
    },
    /**
     * 转换为字符
     * @param v {object}
     * @returns {string}
     */
    toString: function (v) {
        return Object.prototype.toString.apply(v);
    },
    /**
     * 判断值是否已定义
     * @param v {*}
     * @returns {boolean}
     */
    isDefined: function (v) {
        return typeof v !== "undefined";
    },
    /**
     * 是否为空
     * @param v  {*} 值
     * @param allowBlank {boolean} 是否允许空
     * @returns {boolean|*}
     */
    isEmpty: function (v, allowBlank) {
        return v === null || v === undefined || String(v).toUpperCase() === "NULL" || Fw.isArray(v) && !v.length || (!allowBlank ? v === "" : false);
    },
    /**
     * 是否是数组
     * @param v
     * @returns {boolean}
     */
    isArray: function (v) {
        return Fw.toString(v) === "[object Array]";
    },
    /**
     * 是否是数值型
     * @param v
     * @returns {boolean}
     */
    isNumber: function (v) {
        return typeof v === "number" && isFinite(v);
    },
    /**
     * 是否是字符型
     * @param v
     * @returns {boolean}
     */
    isString: function (v) {
        return typeof v === "string";
    },
    /**
     * 是否是布尔型
     * @param v
     * @returns {boolean}
     */
    isBoolean: function (v) {
        return typeof v === "boolean";
    },
    /**
     * 是否是原始类型
     * @param v
     * @returns {*|boolean}
     */
    isPrimitive: function (v) {
        return Fw.isString(v) || Fw.isNumber(v) || Fw.isBoolean(v);
    },
    /**
     * 是否是对象
     * @param v
     * @returns {boolean}
     */
    isObject: function (v) {
        return !!v && Fw.toString(v) === "[object Object]";
    },
    /**
     * 是否可迭代
     * @param v
     * @returns {*}
     */
    isIterable: function (v) {
        return v && typeof v !== "string" ? Fw.isDefined(v.length) : false;
    },
    /**
     * 遍历数组
     * @param value
     * @param fn
     * @param scope
     * @returns {number}
     */
    each: function (value, fn, scope) {
        if (Fw.isEmpty(value)) {
            return;
        }
        if (!Fw.isDefined(scope)) {
            scope = value;
        }
        if (Fw.isObject(value)) {
            var i = 0;
            for (var prop in value) {
                if (value.hasOwnProperty(prop)) {
                    if (fn.call(scope || value, prop, value[prop], i++, value) === false) {
                        return;
                    }
                }
            }
        } else {
            if (!Fw.isIterable(value) || Fw.isPrimitive(value)) {
                value = [value];
            }
            for (var i = 0, len = value.length; i < len; i++) {
                if (fn.call(scope || value[i], value[i], i, value) === false) {
                    return i;
                }
            }
        }
    },
    /**
     * 获取方法名称
     * @param func 方法对象
     * @param decodeURL 是否转码，如果该函数的接收参数中包含URL，则该参数需要置为true
     * @returns {*}
     */
    getFunctionName: function (func, decodeURL) {
        if (func == null || func == "") {
            return "";
        }
        if (Object.prototype.toString.apply(func) !== "[object Function]") {
            return func;
        }
        var funcName = Fw.id();
        // 创建可被调用的临时方法
        window[funcName] = function () {
            var args = [];
            Fw.each(arguments, function (arg) {
                if (true == decodeURL) {
                    arg = decodeURIComponent(arg);
                }
                if ("string" == typeof arg && "{" == arg.charAt(0) && "}" == arg.charAt(arg.length - 1)) {
                    arg = JSON.parse(arg.replace(/<\/?[^>]*>/g, "").replace(/[\r\n\t]/g, "<br>"));
                }
                args.push(arg);
            }, this);
            func.apply(this, args);
            delete window[funcName];
        };
        return funcName;
    }
};

(function () {
    window.Device = function () {
        var device = {};
        var ua = navigator.userAgent;
        var android = ua.match(/(Android);?[\s\/]+([\d.]+)?/);
        var ipad = ua.match(/(iPad).*OS\s([\d_]+)/);
        var ipod = ua.match(/(iPod)(.*OS\s([\d_]+))?/);
        var iphone = !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/);
        device.ios = device.android = device.iphone = device.ipad = false;
        device.os = "web";
        // Android
        if (android) {
            device.os = "android";
            device.osVersion = android[2];
            device.android = true;
        }
        if (ipad || iphone || ipod) {
            device.os = "iphone";
            device.ios = true;
        }
        // iOS
        if (iphone && !ipod) {
            device.osVersion = iphone[2].replace(/_/g, ".");
            device.iphone = true;
        }
        if (ipad) {
            device.osVersion = ipad[2].replace(/_/g, ".");
            device.ipad = true;
        }
        if (ipod) {
            device.osVersion = ipod[3] ? ipod[3].replace(/_/g, ".") : null;
            device.iphone = true;
        }
        // iOS 8+ changed UA
        if (device.ios && device.osVersion && ua.indexOf("Version/") >= 0) {
            if (device.osVersion.split(".")[0] === "10") {
                device.osVersion = ua.toLowerCase().split("version/")[1].split(" ")[0];
            }
        }
        return device;
    }();
    console.info(window.Device.os);
    if (window.Device.os == "iphone") {
        var x5 = {
            commandQueue: [],
            // 数组
            commandQueueFlushing: false,
            resources: {
                base: !0
            }
        };
        window.x5 = x5;
        x5.callbackId = 0;
        x5.callbacks = {};
        x5.callbackStatus = {
            NO_RESULT: 0,
            OK: 1,
            CLASS_NOT_FOUND_EXCEPTION: 2,
            ILLEGAL_ACCESS_EXCEPTION: 3,
            INSTANTIATION_EXCEPTION: 4,
            MALFORMED_URL_EXCEPTION: 5,
            IO_EXCEPTION: 6,
            INVALID_ACTION: 7,
            JSON_EXCEPTION: 8,
            ERROR: 9
        };
        x5.createBridge = function () {
            var bridge = document.createElement("iframe");
            bridge.setAttribute("style", "display:none;");
            bridge.setAttribute("height", "0px");
            bridge.setAttribute("width", "0px");
            bridge.setAttribute("frameborder", "0");
            document.documentElement.appendChild(bridge);
            return bridge;
        };
        x5.exec = function (service, action, options) {
            var command = {
                className: service,
                methodName: action,
                options: {}
            };
            for (var i = 0; i < options.length; ++i) {
                var arg = options[i];
                if (arg == undefined || arg == null) {
                    continue;
                } else if (typeof arg == "object") {
                    command.options = arg;
                }
            }
            x5.commandQueue.push(JSON.stringify(command));
            if (x5.commandQueue.length == 1 && !x5.commandQueueFlushing) {
                if (!x5.bridge) {
                    x5.bridge = x5.createBridge();
                }
                x5.bridge.src = "mszx:" + service + ":" + action;
            }
        };
        // 浏览器调用接口
        x5.getAndClearQueuedCommands = function () {
            var json = JSON.stringify(x5.commandQueue);
            x5.commandQueue = [];
            return json;
        };
        x5.msBridge = function (bridgeFunc, param) {
            try {
                x5.exec("demoid", "executeJSCode_JSDict_", [{
                    "1": bridgeFunc,
                    "2": param || {}
                }]);
            } catch (e) {
                console.error(e);
            }
        };
        var iphone = {
            sendNewThirdLoginReq: function (cfg) {
                x5.msBridge("sendNewThirdLoginReq", cfg);
            },
            _getBtnCfg: function (str) {
                var arr = str.split("|");
                var cfg = {};
                if (arr.length === 3) {
                    if (arr[0] !== "true") return cfg;
                    cfg.exist = arr[0];
                    cfg.name = arr[1] || "返回";
                    cfg.func = arr[2];
                    return cfg;
                }
            },
            initPageTitle: function (title, leftBtn, rightBtn) {
                var leftCfg = this._getBtnCfg(leftBtn);
                var rightCfg = this._getBtnCfg(rightBtn);
                var cfg = {
                    title: title || document.title || "民生信用卡",
                    leftButton: leftCfg,
                    rightButton: rightCfg
                };
                x5.msBridge("setNavgationBar", cfg);
            },
            gotoIndex: function () {
                x5.msBridge("goBack", {});
            },
            returnPage:function(cfg) {
                x5.msBridge("returnPage", cfg);
            },
            goPay: function (cfg) {
                x5.msBridge("goPay", cfg);
            },
            hidenPageTitle: function (cfg) {
                x5.msBridge("resetNavbarBarInThreeWeb", cfg);
            },
            jumpToThird: function (cfg) {
                x5.msBridge("jumpToThird", cfg);
            },
            shareCmbcCredit: function (cfg) {
                x5.msBridge("share", cfg);
            },
            disableScroll: function () {
                x5.msBridge('disableScroll', {});
            },
            enableScroll: function () {
                x5.msBridge('enableScroll', {});
            },
            openNewWebPanel: function (cfg) {
                x5.msBridge('openNewWebPanel', cfg);
            },
            newScan: function(cfg) {
                x5.msBridge('newScan', cfg);
            },
            closeCurWebPanel: function () {
                x5.msBridge('closeCurWebPanel', {});
            },
            getLocation: function (cfg) {
                x5.msBridge('getLocation', cfg);
            },
            getStepCount: function (cfg) { 
                x5.msBridge('getStepCount', cfg)
             },
			 thirdDreamValueQuery: function (cfg) {
                x5.msBridge('thirdDreamValueQuery', cfg);
            },
			thirdDreamValueSubStatus: function (cfg) {
                x5.msBridge('thirdDreamValueSubStatus', cfg);
            },
			thirdDreamValueSub: function (cfg) {
                x5.msBridge('thirdDreamValueSub', cfg);
            },
			thirdDreamValueAdd: function (cfg) {
                x5.msBridge('thirdDreamValueAdd', cfg);
            }
        };
        Fw.Client = iphone;
    } else {
        var cmbc = {};
        window.cmbc = cmbc;
        cmbc.msBridge = function (className, bridgeFunc, param) {
            try {
                window["InteractJsFor" + className][bridgeFunc](JSON.stringify(param));
            } catch (e) {
                console.error(e);
            }
        };
        var android = {
            sendNewThirdLoginReq: function (cfg) {
                cmbc.msBridge("Comm", "sendNewThirdLoginReq", cfg || {});
            },
            _getBtnCfg: function (str) {
                var arr = str.split("|");
                var cfg = {
                    exist: "false"
                };
                if (arr.length === 3) {
                    if (arr[0] !== "true") return cfg;
                    cfg.exist = arr[0];
                    cfg.name = arr[1] || "返回";
                    cfg.success = arr[2];
                    return cfg;
                }
            },
            initPageTitle: function (title, leftBtn, rightBtn) {
                var leftCfg = this._getBtnCfg(leftBtn);
                var rightCfg = this._getBtnCfg(rightBtn);
                var cfg = {
                    title: title || document.title || "民生信用卡",
                    leftButton: leftCfg,
                    rightButton: rightCfg
                };
                cmbc.msBridge("UI", "updateTitle", cfg);
            },
            gotoIndex: function () {
                cmbc.msBridge("Comm", "goHomePage", {});
            },
            returnPage:function() {
                cmbc.msBridge("Comm", "returnPage", {});
            },
            goPay: function (cfg) {
                cmbc.msBridge("Comm", "goPay", cfg);
            },
            showPageTitle: function (cfg) {
                cmbc.msBridge("UI", "setTitleVisible", cfg);
            },
            hidenPageTitle: function (cfg) {
                cmbc.msBridge("UI", "setTitleVisible", cfg);
            },
            jumpToThird: function (cfg) {
                cmbc.msBridge("Comm", "jumpToThird", cfg);
            },
            shareCmbcCredit: function (cfg) {
                cmbc.msBridge("Comm", "share", cfg);
            },
            openNewWebPanel: function (cfg) {
                cmbc.msBridge("Comm", "openNewWebPanel", cfg);
            },
            newScan: function(cfg) {
                cmbc.msBridge("Comm", 'newScan', cfg);
            },
            closeCurWebPanel: function () {
                cmbc.msBridge("Comm", "returnPage", {});
            },
            getLocation: function (cfg) {
                cmbc.msBridge('Comm','getLocation', cfg);
            },
            getStepCount: function (cfg) { 
                cmbc.msBridge('Comm', 'getStepCount', cfg)
             },
			 thirdDreamValueQuery: function (cfg) {
                cmbc.msBridge('Comm','thirdDreamValueQuery', cfg);
            },
			thirdDreamValueSubStatus: function (cfg) {
                cmbc.msBridge('Comm','thirdDreamValueSubStatus', cfg);
            },
			thirdDreamValueSub: function (cfg) {
                cmbc.msBridge('Comm','thirdDreamValueSub', cfg);
            },
			thirdDreamValueAdd: function (cfg) {
                cmbc.msBridge('Comm','thirdDreamValueAdd', cfg);
            }
        };
        Fw.Client = android;
    }
})();