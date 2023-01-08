package com.mickeymeng.framework.middleware.file.core.enums;

import cn.hutool.core.util.ArrayUtil;
import com.mickeymeng.framework.middleware.file.core.client.FileClient;
import com.mickeymeng.framework.middleware.file.core.client.FileClientConfig;
import com.mickeymeng.framework.middleware.file.core.client.db.DBFileClient;
import com.mickeymeng.framework.middleware.file.core.client.db.DBFileClientConfig;
import com.mickeymeng.framework.middleware.file.core.client.ftp.FtpFileClient;
import com.mickeymeng.framework.middleware.file.core.client.ftp.FtpFileClientConfig;
import com.mickeymeng.framework.middleware.file.core.client.local.LocalFileClient;
import com.mickeymeng.framework.middleware.file.core.client.local.LocalFileClientConfig;
import com.mickeymeng.framework.middleware.file.core.client.s3.S3FileClient;
import com.mickeymeng.framework.middleware.file.core.client.s3.S3FileClientConfig;
import com.mickeymeng.framework.middleware.file.core.client.sftp.SftpFileClient;
import com.mickeymeng.framework.middleware.file.core.client.sftp.SftpFileClientConfig;
import com.mickeymeng.framework.middleware.file.core.client.db.DBFileClientConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文件存储器枚举
 *
 * @author 芋道源码
 */
@AllArgsConstructor
@Getter
public enum FileStorageEnum {

    DB(1, DBFileClientConfig.class, DBFileClient.class),

    LOCAL(10, LocalFileClientConfig.class, LocalFileClient.class),
    FTP(11, FtpFileClientConfig.class, FtpFileClient.class),
    SFTP(12, SftpFileClientConfig.class, SftpFileClient.class),

    S3(20, S3FileClientConfig.class, S3FileClient.class),
    ;

    /**
     * 存储器
     */
    private final Integer storage;

    /**
     * 配置类
     */
    private final Class<? extends FileClientConfig> configClass;
    /**
     * 客户端类
     */
    private final Class<? extends FileClient> clientClass;

    public static FileStorageEnum getByStorage(Integer storage) {
        return ArrayUtil.firstMatch(o -> o.getStorage().equals(storage), values());
    }

}
