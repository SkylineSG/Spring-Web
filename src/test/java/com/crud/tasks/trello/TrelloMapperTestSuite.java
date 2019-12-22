package com.crud.tasks.trello;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    TrelloMapper trelloMapper;

    @Autowired
    TaskMapper taskMapper;

    @Test
    public void mapToLists() {
        //given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("list1", "one", true));

        //when
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListsDto);

        //then
        assertEquals(1, trelloLists.size());
        assertTrue(trelloLists.contains(new TrelloList("list1", "one", true)));
    }

    @Test
    public void mapToListsDto() {
        //given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("list2", "two", true));

        //when
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(trelloLists);

        //then
        assertEquals(1, trelloListsDto.size());
        assertTrue(trelloListsDto.contains(new TrelloListDto("list2", "two", true)));

    }

    @Test
    public void mapToBoards() {
        //given
        TrelloListDto trelloListDto = new TrelloListDto("list1", "one", true);
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloListDto);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("board1", "one", trelloListsDto);
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto);

        //when
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //then
        assertEquals(1, trelloBoards.size());

        assertTrue(
                trelloBoards.contains(new TrelloBoard("board1", "one",
                        Arrays.asList(new TrelloList("list1", "jeden", true)))));
    }

    @Test
    public void mapToBoardsDto() {
        //given
        TrelloList trelloList = new TrelloList("list1", "one", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard("board1", "one", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);

        //when
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //then
        assertEquals(1, trelloBoardsDto.size());
        assertTrue(trelloBoardsDto.contains(new TrelloBoardDto("board1", "one",
                Arrays.asList(new TrelloListDto("list1", "one", true)))));
    }

    @Test
    public void mapToCard() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card1", "des1", "pos1", "id1");

        //when
        TrelloCard trelloCard = trelloMapper.mapToTrelloCard(trelloCardDto);

        //then
        assertEquals(new TrelloCard("card1", "des1", "pos1", "id1"), trelloCard);
    }

    @Test
    public void mapToCardDto() {
        //given
        TrelloCard trelloCard = new TrelloCard("card1", "des1", "pos1", "id1");

        //when
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //then
        assertEquals(new TrelloCardDto("card1", "des1", "pos1", "id1"), trelloCardDto);
    }
    @Test
    public void mapToTask() {
        //given
        TaskDto taskDto = new TaskDto(1L,"card1", "des1");

        //when
        Task task = taskMapper.mapToTask(taskDto);

        //then
        assertEquals(new Task(1L,"card1", "des1"), task);
    }

    @Test
    public void mapToTaskDto() {
        //given
        Task task = new Task(1L,"card1", "des1");

        //when
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //then
        assertEquals(new TaskDto(1L,"card1", "des1"), taskDto);
    }

}
