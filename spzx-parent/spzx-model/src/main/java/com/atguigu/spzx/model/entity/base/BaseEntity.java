package com.atguigu.spzx.model.entity.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 说明：mysql数据库运行在docker容器中，所以要修改mysql容器的时区为Asia/Shanghai。
 * docker exec -it mysql bash
 * ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
 * exit
 * docker restart mysql
 */
@Data
public class BaseEntity implements Serializable {

    @Schema(description = "唯一标识")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "创建时间")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "修改时间")
    private Date updateTime;

    @Schema(description = "是否删除")
    private Integer isDeleted;

}