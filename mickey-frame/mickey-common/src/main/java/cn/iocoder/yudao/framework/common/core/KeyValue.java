package cn.iocoder.yudao.framework.common.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;

/**
 * Key Value 的键值对
 *
 * @author 芋道源码
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class KeyValue<K, V> {

    private K key;
    private V value;

}
