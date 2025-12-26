package com.mcpserverstdio.tool;

import com.mcpserverstdio.entity.HelpDeskTicket;
import com.mcpserverstdio.model.TicketRequest;
import com.mcpserverstdio.service.HelpDeskTicketService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HelpDeskTools {
    private static final Logger logger = LoggerFactory.getLogger(HelpDeskTools.class);
    private final HelpDeskTicketService helpDeskTicketService;

    @Tool(name = "createTicket", description = "Create the support ticket")
    String createTicket(@ToolParam(description = "Details to create a support ticket") TicketRequest ticketRequest) {
        logger.info("Create support ticket for user: {} with details {}", ticketRequest.username(), ticketRequest);
        HelpDeskTicket savedTicket = helpDeskTicketService.createTicket(ticketRequest);
        logger.info("Ticket created successfully. Ticket ID: {}, Username: {}", savedTicket.getId(), savedTicket.getUsername());
        return "Ticket #" + savedTicket.getId() + " create successfully for user " + savedTicket.getUsername();
    }

    @Tool(name = "getTicketStatus", description = "Fetch the status of the open tickets based on given username")
    List<HelpDeskTicket> getTicketStatus(@ToolParam(description = "Username to fetch the status of the help desk tickets") String username) {
        logger.info("Fetch the status of the open tickets based on username: {}", username);
        List<HelpDeskTicket> tickets = helpDeskTicketService.getTicketsByUsername(username);
        logger.info("Found {} tickets for user {}", tickets.size(), username);
        return tickets;
    }
}
