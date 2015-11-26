import info.developerblog.services.auth.TUser
import info.developerblog.services.user.TFbiResponse
import info.developerblog.services.user.TFbiService
import org.apache.thrift.protocol.TProtocol
import org.apache.thrift.protocol.TProtocolFactory
import org.apache.thrift.transport.THttpClient
import org.apache.thrift.transport.TTransport
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import ru.joker.FbiApplication

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FbiApplication.class)
@WebIntegrationTest("server.port:0")
class ThriftTests {
  @Value('${local.server.port}')
  int port;

  @Autowired
  TProtocolFactory protocolFactory;

  TFbiService.Iface client;

  @Before
  public void setUp() {
    TTransport transport = new THttpClient("http://localhost:" + port + "/api")

    TProtocol protocol = protocolFactory.getProtocol(transport)

    client = new TFbiService.Client(protocol)
  }

  @Test
  public void testSimpleCall() {
    TUser user = new TUser().setUserId(1L);

    TFbiResponse response = client.fink(user, 2, 10)

    println response.getLastFink()
  }
}