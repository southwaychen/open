package com.open.api.entity.vo;

/**
 * RPC调用返回码枚举类
 * 对应方法调用返回值中的rpcRetCode和rpcRetMsg
 * Created by admin on 2016/4/27.
 */
public enum ResponseCode {

    // 0000: 成功
    RET_SUCCESS("00000000", "操作成功!"),

    // 失败(00开始标示通讯层相关错误码)
    RET_REMOTE_UNUSABLE("00000001", "远程服务不可用"),
    RET_REMOTE_INVALID("00000002", "客户端非法调用"),
    RET_NO_BIZ_SEQUENCE_NO("00000003", "远程服务调用业务流水号不存在"),
    RET_REMOTE_CHECK_SIGN_FAIL("00000004", "远程服务调用签名验证失败"),
    RET_REMOTE_RPC_SEQ_NO_REPEATED("00000005", "随机通讯码在指定时间内重复"),
    RET_REMOTE_SIGN_INVALID("00000006", "远程服务调用签名计算方式错误"),
    RET_REMOTE_DEAL_EXCEPTION("00000007", "远程服务调用处理异常"),
    RET_REMOTE_PROTOCOL_INVALID("00000008", "客户端调用协议非法"),
    RET_REMOTE_HTTP_METHOD_INVALID("00000009", "客户端请求方式非法"),

    // 失败(01开始标示参数校验相关错误码)
    RET_PARAM_NOT_FOUND("00000101", "参数为空或参数错误!"),
    RET_PARAM_INVALID("00000102", "无效的参数"),
    RET_PARAM_TOO_LARGE_LIST("00000103", "列表超长"),
    RET_PARAM_TYPE_INVALID("00000104", "参数类型错误"),
    RET_CURRENT_PAGE_INVALID("00000105", "当前页码非法"),
    RET_VIEW_NUMBER_INVALID("00000106", "分页显示数目非法"),
    RET_VIEW_LIMIT_INVALID("00000107", "数据排列显示数目非法"),

    //  失败(02开始标示DB操作相关错误码)


    // 业务相关
    RET_USER_DATA_NOT_EXISTS("00001001", "用户不存在"),
    RET_BIZ_DATA_NOT_EXISTS("00001001", "数据不存在"),
    RET_BIZ_SING_DATA_FAIL("00001002", "商户签名数据不正确"),
    RET_BIZ_WX_PAY_CREATE_FAIL("00001003", "微信支付下单失败"),
    RET_BIZ_ALI_PAY_CREATE_FAIL("00001004", "支付宝支付下单失败"),
    RET_BIZ_PAY_NOTIFY_VERIFY_FAIL("00001005", "支付通知数据验证不正确"),


    // 未知错误
    RET_UNKNOWN_ERROR("00009999", "未知错误");

    private String code;
    private String msg;

    private ResponseCode(String code, String msg) { this.code = code;
        this.msg = msg; }

    public String getCode()
    {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public static ResponseCode getRetEnum(String code) {
        if (code == null) {
            return null;
        }

        ResponseCode[] values = ResponseCode.values();
        for (ResponseCode e : values) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }
}
