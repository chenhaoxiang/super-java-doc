/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.test.vo;

/**
 * 用户账户
 *
 * @author chenhx
 * @version Account.java, v 0.1 2018-09-26 下午 6:24
 */

public class Account {

    /**
     * 账户ID,跟用户ID一致
     */
    private String id;

    /**
     * 用户余额
     */
    private Double balance;

    /**
     * 用户积分
     */
    private Integer score;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>balance</tt>.
     *
     * @return property value of balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Setter method for property <tt>balance</tt>.
     *
     * @param balance value to be assigned to property balance
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * Getter method for property <tt>score</tt>.
     *
     * @return property value of score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Setter method for property <tt>score</tt>.
     *
     * @param score value to be assigned to property score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append(super.toString());
        sb.append(",");
        sb.append("id='").append(id).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
