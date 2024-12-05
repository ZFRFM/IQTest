package ru.faimizufarov.worker.vacancy.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import eu.bambooapps.material3.pullrefresh.PullRefreshIndicator
import eu.bambooapps.material3.pullrefresh.PullRefreshIndicatorDefaults
import eu.bambooapps.material3.pullrefresh.pullRefresh
import eu.bambooapps.material3.pullrefresh.rememberPullRefreshState
import ru.faimizufarov.worker.vacancy.models.VacancyCompose

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VacancyScreenBase(
    vacanciesList: LazyPagingItems<VacancyCompose>,
    modifier: Modifier = Modifier,
) {
    val isRefreshing by remember {
        mutableStateOf(vacanciesList.loadState.refresh is LoadState.Loading)
    }
    val state = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = { vacanciesList.refresh() }
    )
    LazyColumn(
        modifier =
        modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .pullRefresh(state),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(vacanciesList.itemCount) {index: Int ->
            vacanciesList[index]?.let {
                VacancyItem(
                    vacancy = it
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        item {
            PullRefreshIndicator(
                refreshing = isRefreshing,
                state = state,
                modifier = Modifier,
                colors = PullRefreshIndicatorDefaults.colors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            )
        }
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}