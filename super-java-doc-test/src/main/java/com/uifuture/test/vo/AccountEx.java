/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.test.vo;

import java.util.Date;

/**
 * @author chenhx
 * @version AccountEx.java, v 0.1 2018-09-26 下午 6:25
 */

public class AccountEx extends Account {

    /**
     * 创建时间
     */
    private Date createdtime;


    /**
     * 等级,数字越高级别越大
     */
    private Integer level;

    /**
     * 重写父类的注释,新的含义是:已消费的积分
     */
    private Integer score;

    /**
     * Getter method for property <tt>createdtime</tt>.
     *
     * @return property value of createdtime
     */
    public Date getCreatedtime() {
        return createdtime;
    }

    /**
     * Setter method for property <tt>createdtime</tt>.
     *
     * @param createdtime value to be assigned to property createdtime
     */
    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    /**
     * Getter method for property <tt>level</tt>.
     *
     * @return property value of level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Setter method for property <tt>level</tt>.
     *
     * @param level value to be assigned to property level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * Getter method for property <tt>score</tt>.
     *
     * @return property value of score
     */
    @Override
    public Integer getScore() {
        return score;
    }

    /**
     * Setter method for property <tt>score</tt>.
     *
     * @param score value to be assigned to property score
     */
    @Override
    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountEx{");
        sb.append(super.toString());
        sb.append(",");
        sb.append("createdtime=").append(createdtime);
        sb.append(", level=").append(level);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
