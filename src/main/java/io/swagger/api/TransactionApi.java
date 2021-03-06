/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.23).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.exception.BadInputException;
import io.swagger.exception.LimitReachedException;
import io.swagger.exception.NotFoundException;
import io.swagger.model.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-21T13:18:37.550Z[GMT]")
public interface TransactionApi {

    @Operation(summary = "Adds a transaction with form data", description = "Adds a transaction to the system", tags = {"transactions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "item created"),

            @ApiResponse(responseCode = "400", description = "invalid input, object invalid")})
    @RequestMapping(value = "/transaction",
            consumes = {"application/json", "application/xml"},
            method = RequestMethod.POST)
    ResponseEntity addTransaction(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Transaction body) throws NotFoundException, BadInputException, LimitReachedException;


    @Operation(summary = "Get a transactions by ID", description = "Returns a single transaction", tags = {"transactions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Transaction.class)))),

            @ApiResponse(responseCode = "400", description = "Bad input parameter"),

            @ApiResponse(responseCode = "404", description = "Transaction not found")})
    @RequestMapping(value = "/transaction/{transactionId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity getTransactionById(@Parameter(in = ParameterIn.PATH, description = "ID of transaction to return", required = true, schema = @Schema()) @PathVariable("transactionId") Long transactionId) throws NotFoundException;


    @Operation(summary = "Get transactions from an account", description = "Returns transactions from a specific account", tags = {"transactions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Transaction.class)))),

            @ApiResponse(responseCode = "400", description = "Bad input parameter"),

            @ApiResponse(responseCode = "404", description = "Account not found")})
    @RequestMapping(value = "/transaction/account/{accountId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Transaction>> getTransactionFromAccount(@Parameter(in = ParameterIn.PATH, description = "ID of an account", required = true, schema = @Schema()) @PathVariable("accountId") String accountId) throws NotFoundException, BadInputException;


    @Operation(summary = "Get transactions from an user", description = "Returns transaction from a specific user", tags = {"transactions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Transaction.class)))),

            @ApiResponse(responseCode = "400", description = "Bad input parameter"),

            @ApiResponse(responseCode = "404", description = "User not found")})
    @RequestMapping(value = "/transaction/user/{userId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Transaction>> getTransactionFromUser(@Parameter(in = ParameterIn.PATH, description = "ID of a user", required = true, schema = @Schema()) @PathVariable("userId") Long userId) throws NotFoundException;

}

