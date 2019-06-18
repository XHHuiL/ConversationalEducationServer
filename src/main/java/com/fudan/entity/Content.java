package com.fudan.entity;

import java.io.Serializable;

/**
 * content
 * @author 
 */
public class Content implements Serializable {
    private Integer id;

    private String text;

    private Integer type;

    private Integer chapterId;

    private Integer nextContent;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getNextContent() {
        return nextContent;
    }

    public void setNextContent(Integer nextContent) {
        this.nextContent = nextContent;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Content other = (Content) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getChapterId() == null ? other.getChapterId() == null : this.getChapterId().equals(other.getChapterId()))
            && (this.getNextContent() == null ? other.getNextContent() == null : this.getNextContent().equals(other.getNextContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getChapterId() == null) ? 0 : getChapterId().hashCode());
        result = prime * result + ((getNextContent() == null) ? 0 : getNextContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", text=").append(text);
        sb.append(", type=").append(type);
        sb.append(", chapterId=").append(chapterId);
        sb.append(", nextContent=").append(nextContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}