# Spring

## HTTP status codes
<table>
  <thead>
    <tr>
      <th>Classes</th>
      <th>Status Code</th>
      <th>Response</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>2xx Success</b></td>
      <td>200</td>
      <td>OK, standard response for successful HTTP request</td>
    </tr>
    <tr>
      <td rowspan="5"><b>4xx Client Errors</b></td>
      <td>400</td>
      <td>Bard Request. Apparent client error surch as malfored request syntax, size too large, invalid request message framing, or deceptive request routing</td>
    </tr>
    <tr>
      <td>401</td>
      <td>Unauthorized, the user does not have valid authentication credentials for the target source</td>
    </tr>
    <tr>
      <td>403</td>
      <td><b>Forbidden</b>The server is refusing action due to the user not having necessary permissions for a resource or needing an account of some sort, or attempting a prohibited action</td>
    </tr>
    <tr>
      <td>404</td>
      <td><b>Not Found</b>, The requested resource could not be found but may be available in the future</td>
    </tr>
    <tr>
      <td>406</td>
      <td>Not acceptable</td>
    </tr>
    <tr>
      <td rowspan="3"><b>5xx Server Errors</b></td>
      <td>500</td>
      <td>Internal Server Error, A generic error message, given when an unexpected condition was encountered and no more specific message is suitable</td>
    </tr>
    <tr>
      <td>501</td>
      <td>Not Implemented, The server either does not recognize the request method or lacks the ability to fulfill the request</td>
    </tr>
    <tr>
      <td>502</td>
      <td>Bad Gateway, The server was acting as a gateway or proxy and received an invalid response from the upstream server</td>
    </tr>
  </tbody>
</table>
