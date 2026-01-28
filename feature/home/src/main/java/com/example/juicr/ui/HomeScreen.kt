package com.example.juicr.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.juicr.feature.home.R
import com.example.juicr.ui.components.SearchBar


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
){
  HomeContent(
      modifier,
      onSearch = { query ->
          viewModel.searchJuices(query)
      }
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onSearch: (text: String) -> Unit
    ) {

    val scrollBehaviour = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = { Text(stringResource(R.string.homescreen_topbar_text)) },
                actions = {

                },
                scrollBehavior = scrollBehaviour
            )
        }
    ) { inner ->
        Column(
            modifier = Modifier.padding(inner)
        ) {
            SearchBar(
                onSearch = { query ->
                    onSearch(query)
                }
            )
        }
    }

}
@Preview
@Composable
fun HomePreview() {
    HomeScreen()
}