package com.ctgtmo.sshr.adminbiz;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.xxl.job.core.biz.AdminBiz;
import com.xxl.job.core.biz.client.AdminBizClient;
import com.xxl.job.core.biz.model.HandleCallbackParam;
import com.xxl.job.core.biz.model.RegistryParam;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.enums.RegistryConfig;

/**
 * admin api test
 *
 * @author xuxueli 2017-07-28 22:14:52
 */
public class AdminBizTest {

  // admin-client
  private static String addressUrl = "http://127.0.0.1:8080/xxl-job-admin/";

  private static String accessToken = null;

  @Test
  public void callback() throws Exception {
    AdminBiz adminBiz = new AdminBizClient(addressUrl, accessToken);

    HandleCallbackParam param = new HandleCallbackParam();
    param.setLogId(1);
    param.setExecuteResult(ReturnT.SUCCESS);

    List<HandleCallbackParam> callbackParamList = Arrays.asList(param);

    ReturnT<String> returnT = adminBiz.callback(callbackParamList);

    Assert.assertTrue(returnT.getCode() == ReturnT.SUCCESS_CODE);
  }

  /**
   * registry executor
   *
   * @throws Exception
   */
  @Test
  public void registry() throws Exception {
    AdminBiz adminBiz = new AdminBizClient(addressUrl, accessToken);

    RegistryParam registryParam = new RegistryParam(RegistryConfig.RegistType.EXECUTOR.name(), "xxl-job-executor-example", "127.0.0.1:9999");
    ReturnT<String> returnT = adminBiz.registry(registryParam);

    Assert.assertTrue(returnT.getCode() == ReturnT.SUCCESS_CODE);
  }

  /**
   * registry executor remove
   *
   * @throws Exception
   */
  @Test
  public void registryRemove() throws Exception {
    AdminBiz adminBiz = new AdminBizClient(addressUrl, accessToken);

    RegistryParam registryParam = new RegistryParam(RegistryConfig.RegistType.EXECUTOR.name(), "xxl-job-executor-example", "127.0.0.1:9999");
    ReturnT<String> returnT = adminBiz.registryRemove(registryParam);

    Assert.assertTrue(returnT.getCode() == ReturnT.SUCCESS_CODE);

  }

}
