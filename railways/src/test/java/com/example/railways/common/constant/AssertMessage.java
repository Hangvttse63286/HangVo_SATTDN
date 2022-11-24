package com.example.railways.common.constant;

public enum AssertMessage {
    ELEMENT_NOT_DISPLAYED("This element is not existed or displayed on UI: "),
    ELEMENT_STILL_DISPLAYED("This element is still existed or displayed on UI: "),
    VALUE_MISMATCH_WITH_EXPECTED("The value of this element is not equal with expected: ");

    private final String msg;

    AssertMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
