package software.amazon.ce.anomalymonitor;

import software.amazon.awssdk.awscore.exception.AwsErrorDetails;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.services.costexplorer.CostExplorerClient;
import software.amazon.awssdk.services.costexplorer.model.CreateAnomalyMonitorResponse;
import software.amazon.cloudformation.exceptions.CfnInvalidRequestException;
import software.amazon.cloudformation.proxy.AmazonWebServicesClientProxy;
import software.amazon.cloudformation.proxy.HandlerErrorCode;
import software.amazon.cloudformation.proxy.Logger;
import software.amazon.cloudformation.proxy.OperationStatus;
import software.amazon.cloudformation.proxy.ProgressEvent;
import software.amazon.cloudformation.proxy.ResourceHandlerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class CreateHandlerTest {

    @Mock
    private AmazonWebServicesClientProxy proxy;

    @Mock
    private Logger logger;

    private final CreateHandler handler = new CreateHandler(mock(CostExplorerClient.class));

    @BeforeEach
    public void setup() {
        proxy = mock(AmazonWebServicesClientProxy.class);
        logger = mock(Logger.class);
    }

    @Test
    public void handleRequest_Success_DimensionalMonitor() {
        final ResourceModel model = ResourceModel.builder()
                .monitorName(TestFixtures.MONITOR_NAME)
                .monitorType(TestFixtures.MONITOR_TYPE_DIMENSIONAL)
                .build();

        final ResourceHandlerRequest<ResourceModel> request = ResourceHandlerRequest.<ResourceModel>builder()
                .desiredResourceState(model)
                .build();

        final CreateAnomalyMonitorResponse mockResponse = CreateAnomalyMonitorResponse.builder()
                .monitorArn(TestFixtures.MONITOR_ARN)
                .build();

        doReturn(mockResponse)
                .when(proxy).injectCredentialsAndInvokeV2(any(), any());

        final ProgressEvent<ResourceModel, CallbackContext> response
                = handler.handleRequest(proxy, request, null, logger);

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(OperationStatus.SUCCESS);
        assertThat(response.getCallbackContext()).isNull();
        assertThat(response.getCallbackDelaySeconds()).isEqualTo(0);
        assertThat(response.getResourceModel()).isEqualTo(request.getDesiredResourceState());
        assertThat(response.getResourceModels()).isNull();
        assertThat(response.getMessage()).isNull();
        assertThat(response.getErrorCode()).isNull();
    }

    @Test
    public void handleRequest_Success_TagsMonitor() {
        final ResourceModel model = ResourceModel.builder()
                .monitorName(TestFixtures.MONITOR_NAME)
                .monitorType(TestFixtures.MONITOR_TYPE_CUSTOM)
                .monitorSpecification(TestFixtures.TAGS_MONITOR_SPEC)
                .resourceTags(TestFixtures.RESOURCE_TAGS)
                .build();

        final ResourceHandlerRequest<ResourceModel> request = ResourceHandlerRequest.<ResourceModel>builder()
                .desiredResourceState(model)
                .build();

        final CreateAnomalyMonitorResponse mockResponse = CreateAnomalyMonitorResponse.builder()
                .monitorArn(TestFixtures.MONITOR_ARN)
                .build();

        doReturn(mockResponse)
                .when(proxy).injectCredentialsAndInvokeV2(any(), any());

        final ProgressEvent<ResourceModel, CallbackContext> response
                = handler.handleRequest(proxy, request, null, logger);

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(OperationStatus.SUCCESS);
        assertThat(response.getCallbackContext()).isNull();
        assertThat(response.getCallbackDelaySeconds()).isEqualTo(0);
        assertThat(response.getResourceModel()).isEqualTo(request.getDesiredResourceState());
        assertThat(response.getResourceModels()).isNull();
        assertThat(response.getMessage()).isNull();
        assertThat(response.getErrorCode()).isNull();
    }

    @Test
    public void handleRequest_Success_CCMonitor() {
        final ResourceModel model = ResourceModel.builder()
                .monitorName(TestFixtures.MONITOR_NAME)
                .monitorType(TestFixtures.MONITOR_TYPE_CUSTOM)
                .monitorSpecification(TestFixtures.CC_MONITOR_SPEC)
                .build();

        final ResourceHandlerRequest<ResourceModel> request = ResourceHandlerRequest.<ResourceModel>builder()
                .desiredResourceState(model)
                .build();

        final CreateAnomalyMonitorResponse mockResponse = CreateAnomalyMonitorResponse.builder()
                .monitorArn(TestFixtures.MONITOR_ARN)
                .build();

        doReturn(mockResponse)
                .when(proxy).injectCredentialsAndInvokeV2(any(), any());

        final ProgressEvent<ResourceModel, CallbackContext> response
                = handler.handleRequest(proxy, request, null, logger);

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(OperationStatus.SUCCESS);
        assertThat(response.getCallbackContext()).isNull();
        assertThat(response.getCallbackDelaySeconds()).isEqualTo(0);
        assertThat(response.getResourceModel()).isEqualTo(request.getDesiredResourceState());
        assertThat(response.getResourceModels()).isNull();
        assertThat(response.getMessage()).isNull();
        assertThat(response.getErrorCode()).isNull();
    }

    @Test
    public void handleRequest_Success_LinkedAccountMonitor() {
        final ResourceModel model = ResourceModel.builder()
                .monitorName(TestFixtures.MONITOR_NAME)
                .monitorType(TestFixtures.MONITOR_TYPE_CUSTOM)
                .monitorSpecification(TestFixtures.LINKEDACCOUNT_MONITOR_SPEC)
                .build();

        final ResourceHandlerRequest<ResourceModel> request = ResourceHandlerRequest.<ResourceModel>builder()
                .desiredResourceState(model)
                .build();

        final CreateAnomalyMonitorResponse mockResponse = CreateAnomalyMonitorResponse.builder()
                .monitorArn(TestFixtures.MONITOR_ARN)
                .build();

        doReturn(mockResponse)
                .when(proxy).injectCredentialsAndInvokeV2(any(), any());

        final ProgressEvent<ResourceModel, CallbackContext> response
                = handler.handleRequest(proxy, request, null, logger);

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(OperationStatus.SUCCESS);
        assertThat(response.getCallbackContext()).isNull();
        assertThat(response.getCallbackDelaySeconds()).isEqualTo(0);
        assertThat(response.getResourceModel()).isEqualTo(request.getDesiredResourceState());
        assertThat(response.getResourceModels()).isNull();
        assertThat(response.getMessage()).isNull();
        assertThat(response.getErrorCode()).isNull();
    }

    @Test
    public void handleRequest_Fail_UserAssignValuesToReadOnlyProperties() {
        final ResourceModel model = ResourceModel.builder()
                .monitorName(TestFixtures.MONITOR_NAME)
                .monitorType(TestFixtures.MONITOR_TYPE_DIMENSIONAL)
                .monitorArn(TestFixtures.MONITOR_ARN)
                .build();

        final ResourceHandlerRequest<ResourceModel> request = ResourceHandlerRequest.<ResourceModel>builder()
                .desiredResourceState(model)
                .build();

        final ProgressEvent<ResourceModel, CallbackContext> response
                = handler.handleRequest(proxy, request, null, logger);

        assertThat(response).isNotNull();
        assertThat(response.getCallbackContext()).isNull();
        assertThat(response.getCallbackDelaySeconds()).isEqualTo(0);
        assertThat(response.getResourceModel()).isEqualTo(request.getDesiredResourceState());
        assertThat(response.getResourceModels()).isNull();
        assertThat(response.getStatus()).isEqualTo(OperationStatus.FAILED);
        assertThat(response.getMessage()).isNotNull();
        assertThat(response.getErrorCode()).isNotNull();
    }

    @Test
    public void handleRequest_Fail_UserAssignInvalidTypeToMonitorSpecification() {
        final ResourceModel model = ResourceModel.builder()
                .monitorName(TestFixtures.MONITOR_NAME)
                .monitorType(TestFixtures.MONITOR_TYPE_CUSTOM)
                .monitorSpecification(TestFixtures.INVALID_TYPE_MONITOR_SPEC)
                .build();

        final ResourceHandlerRequest<ResourceModel> request = ResourceHandlerRequest.<ResourceModel>builder()
                .desiredResourceState(model)
                .build();

        assertThatThrownBy(() -> handler.handleRequest(proxy, request, null, logger))
                .isInstanceOf(CfnInvalidRequestException.class)
                .hasMessageContaining("Invalid request provided: Invalid JSON array");
    }

    @Test
    public void handleRequest_Fail_UserAssignInvalidValuesToMonitorSpecification() {
        final ResourceModel model = ResourceModel.builder()
                .monitorName(TestFixtures.MONITOR_NAME)
                .monitorType(TestFixtures.MONITOR_TYPE_CUSTOM)
                .monitorSpecification(TestFixtures.INVALID_VALUE_MONITOR_SPEC)
                .build();

        final ResourceHandlerRequest<ResourceModel> request = ResourceHandlerRequest.<ResourceModel>builder()
                .desiredResourceState(model)
                .build();

        assertThatThrownBy(() -> handler.handleRequest(proxy, request, null, logger))
                .isInstanceOf(CfnInvalidRequestException.class)
                .hasMessageContaining("Invalid request provided: Unsupported JSON array");
    }

    @Test
    public void handleRequest_Fail_MonitorAlreadyExists() {
        final ResourceModel model = ResourceModel.builder()
                .monitorName(TestFixtures.MONITOR_NAME)
                .monitorType(TestFixtures.MONITOR_TYPE_CUSTOM)
                .monitorSpecification(TestFixtures.LINKEDACCOUNT_MONITOR_SPEC)
                .build();

        final ResourceHandlerRequest<ResourceModel> request = ResourceHandlerRequest.<ResourceModel>builder()
                .desiredResourceState(model)
                .build();


        final AwsServiceException exception = AwsServiceException.builder()
                .awsErrorDetails(AwsErrorDetails.builder()
                        .errorMessage(Utils.MONITOR_ALREADY_EXISTS)
                        .build())
                .build();

        doThrow(exception)
                .when(proxy).injectCredentialsAndInvokeV2(any(), any());

        final ProgressEvent<ResourceModel, CallbackContext> response
                = handler.handleRequest(proxy, request, null, logger);

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(OperationStatus.FAILED);
        assertThat(response.getErrorCode()).isEqualTo(HandlerErrorCode.AlreadyExists);
    }

    @Test
    public void handleRequest_Fail_DimensionalMonitorAlreadyExists() {
        final ResourceModel model = ResourceModel.builder()
                .monitorName(TestFixtures.MONITOR_NAME)
                .monitorType(TestFixtures.MONITOR_TYPE_CUSTOM)
                .monitorSpecification(TestFixtures.LINKEDACCOUNT_MONITOR_SPEC)
                .build();

        final ResourceHandlerRequest<ResourceModel> request = ResourceHandlerRequest.<ResourceModel>builder()
                .desiredResourceState(model)
                .build();


        final AwsServiceException exception = AwsServiceException.builder()
                .awsErrorDetails(AwsErrorDetails.builder()
                        .errorMessage(Utils.DIMENSIONAL_MONITOR_ALREADY_EXISTS)
                        .build())
                .build();

        doThrow(exception)
                .when(proxy).injectCredentialsAndInvokeV2(any(), any());

        final ProgressEvent<ResourceModel, CallbackContext> response
                = handler.handleRequest(proxy, request, null, logger);

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(OperationStatus.FAILED);
        assertThat(response.getErrorCode()).isEqualTo(HandlerErrorCode.AlreadyExists);
    }
}
