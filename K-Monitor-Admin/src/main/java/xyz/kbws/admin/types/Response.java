package xyz.kbws.admin.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author kbws
 * @date 2024/7/7
 * @description: 通用返回结果类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    private String code;

    private String info;

    private T data;

    private static final long serialVersionUID = -7448457112301184473L;
}
